package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.dto.HorarioRequestAdd;
import br.unit.AgendaCurso.dto.HorarioResponse;
import br.unit.AgendaCurso.dto.ProfessorRequest;
import br.unit.AgendaCurso.dto.ProfessorResponse;
import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Horario;
import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.repositories.AlunosRepository;
import br.unit.AgendaCurso.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@RestController
@RequestMapping("/api/horario")
class HorarioController {

    @Autowired
    private HorarioRepository _horarioRepository;
    @Autowired
    private AlunosRepository _alunosRepository;

    @PostMapping("/add")
    public HorarioResponse add(@RequestBody HorarioRequestAdd request){
        LocalTime horarioInico = LocalTime.parse(request.getHorario());

        if(_horarioRepository.hasHorario(horarioInico, request.getDia(), request.getIdTurma())){
            return new HorarioResponse(0);
        }

        Horario horario = new Horario();
        horario.setSala(request.getSala());
        horario.setIdTurma(request.getIdTurma());
        horario.setDiaDaSemana(request.getDia());

        horario.setHorarioInicio(horarioInico);

        return new HorarioResponse(_horarioRepository.addHorario(horario));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> delete(@PathVariable int id, Principal principal) {
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));
        if (!Objects.equals(aluno.getRole(), "admin")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        _horarioRepository.deleteHorario(id);
        return ResponseEntity.noContent().build();
    }
}
