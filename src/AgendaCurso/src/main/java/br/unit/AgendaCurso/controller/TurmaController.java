package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.dto.ProfessorRequest;
import br.unit.AgendaCurso.dto.ProfessorResponse;
import br.unit.AgendaCurso.dto.TurmaRequestAdd;
import br.unit.AgendaCurso.dto.TurmaResponse;
import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.models.Turma;
import br.unit.AgendaCurso.repositories.AlunosRepository;
import br.unit.AgendaCurso.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/turma")
class TurmaController {
    @Autowired
    private TurmaRepository _turmaRepository;
    @Autowired
    private AlunosRepository _alunosRepository;

    @PostMapping("/add")
    public TurmaResponse add(@RequestBody TurmaRequestAdd request){
        Turma turma = new Turma(){};
        turma.setNome(request.getNome());
        turma.setIdDiciplina(Integer.parseInt(request.getIdDiciplina()));
        turma.setIdProfessor(Integer.parseInt(request.getIdProfessor()));
        int idGerado = _turmaRepository.addTurma(turma);

        return new TurmaResponse(
                idGerado,
                turma.getNome(),
                turma.getIdDiciplina(),
                turma.getIdProfessor()
        );
    }

    @DeleteMapping("/sairTurma/{id}")
    public ResponseEntity<?> delete(@PathVariable int id, Principal principal) {
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula).orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));
        _turmaRepository.removerAlunoTurma(aluno.getIdAluno(), id);
        return ResponseEntity.ok().build();
    }
}
