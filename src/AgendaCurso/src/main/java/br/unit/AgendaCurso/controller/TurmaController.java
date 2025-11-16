package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.dto.ProfessorRequest;
import br.unit.AgendaCurso.dto.ProfessorResponse;
import br.unit.AgendaCurso.dto.TurmaRequestAdd;
import br.unit.AgendaCurso.dto.TurmaResponse;
import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.models.Turma;
import br.unit.AgendaCurso.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/turma")
class TurmaController {
    @Autowired
    private TurmaRepository _turmaRepository;

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
}
