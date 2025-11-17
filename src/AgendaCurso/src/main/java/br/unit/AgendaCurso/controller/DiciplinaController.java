package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.repositories.AlunosRepository;
import br.unit.AgendaCurso.repositories.DiciplinaRepository;
import br.unit.AgendaCurso.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Objects;

@RestController
@RequestMapping("/api/diciplina")
class DiciplinaController {
    @Autowired
    private DiciplinaRepository _disciplinaRepository;
    @Autowired
    private AlunosRepository _alunosRepository;
    @Autowired
    private TurmaRepository _turmaRepository;

    @PostMapping("/add/{nome}")
    public ResponseEntity<?> add(@PathVariable String nome, Principal principal) {
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));
        if (!Objects.equals(aluno.getRole(), "admin")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Diciplina diciplina = new Diciplina();
        diciplina.setNome(nome);


        _disciplinaRepository.addDiciplina(diciplina);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable int id, Principal principal) {
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));
        if (!Objects.equals(aluno.getRole(), "admin")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        if (_turmaRepository.hasTurmaPorDiciplina(id)) {

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Não é possível deletar diciplinas que possuem turmas.");
        }

        _disciplinaRepository.deleteDiciplina(id);
        return ResponseEntity.noContent().build();
    }
}
