package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.dto.ProfessorRequest;
import br.unit.AgendaCurso.dto.ProfessorResponse;
import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.repositories.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
    @Autowired
    private ProfessoresRepository _professoresRepository;

    @PostMapping("/add")
    public ProfessorResponse add(@RequestBody ProfessorRequest request){
        Professor professor = new Professor();
        professor.setNome(request.getNome());

        return new ProfessorResponse(request.getNome(), _professoresRepository.addProfessor(professor));
    }
}
