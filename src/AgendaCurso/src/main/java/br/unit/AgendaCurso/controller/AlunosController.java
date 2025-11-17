package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.dto.AlunoAddRequest;
import br.unit.AgendaCurso.dto.TurmaRequestAdd;
import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.repositories.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Objects;

@RestController
@RequestMapping("/api/aluno")
class AlunosController {
    @Autowired
    private AlunosRepository _alunosRepository;

    @PostMapping("/add")
    public ResponseEntity<?> index(@RequestBody AlunoAddRequest request, Principal principal) {
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));
        if (!Objects.equals(aluno.getRole(), "admin")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Aluno aluno2 = new Aluno();
        aluno2.setMatricula(gerarProximaMAtricula());
        aluno2.setNome(request.getNome());
        aluno2.setSenha(request.getSenha());
        aluno2.setRole(request.getRole());
        _alunosRepository.addAluno(aluno2);

        return ResponseEntity.noContent().build();
    }

    private String gerarProximaMAtricula (){
        String maxMatricula = _alunosRepository.maxMatricula();
        String subMax = maxMatricula.substring(5, maxMatricula.length());

        LocalDate date = LocalDate.now();
        int ano = date.getYear();
        int  mes = date.getMonthValue();
        int semestre = mes > 6 ? 2 : 1;

        String semestreInico = semestre + "" + ano;

        int subProxInt = Integer.parseInt(subMax) + 1;
        String subProx = subProxInt + "";
        String complemento = "0".repeat(6 - subProx.length());


        return semestreInico + complemento +  subProx;
    }
}
