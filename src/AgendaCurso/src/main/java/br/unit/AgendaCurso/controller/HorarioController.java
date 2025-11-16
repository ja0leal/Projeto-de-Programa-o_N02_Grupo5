package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.dto.HorarioRequestAdd;
import br.unit.AgendaCurso.dto.HorarioResponse;
import br.unit.AgendaCurso.dto.ProfessorRequest;
import br.unit.AgendaCurso.dto.ProfessorResponse;
import br.unit.AgendaCurso.models.Horario;
import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/horario")
class HorarioController {

    @Autowired
    private HorarioRepository _horarioRepository;

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
}
