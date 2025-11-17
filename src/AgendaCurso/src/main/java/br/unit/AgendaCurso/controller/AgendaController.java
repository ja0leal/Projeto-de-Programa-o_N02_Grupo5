package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Diciplina;
import br.unit.AgendaCurso.models.Horario;
import br.unit.AgendaCurso.models.Turma;
import br.unit.AgendaCurso.repositories.*;
import br.unit.AgendaCurso.viewModels.HorarioLinha;
import br.unit.AgendaCurso.viewModels.ProximosHorarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalTime;
import java.util.*;

@Controller
@RequestMapping("/Agenda")
public class AgendaController {

    @Autowired
    private AlunosRepository _alunosRepository;
    @Autowired
    private DiciplinaRepository _diciplinaRepository;
    @Autowired
    private HorarioRepository _horarioRepository;
    @Autowired
    private TurmaRepository _turmaRepository;

    @GetMapping("/")
    public String index(Principal principal, Model model, Map map) {
        if (principal == null) {
            return "index";
        }
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula).orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));
        model.addAttribute("alunoLogado", aluno);


        List<Turma> turmas = _turmaRepository.getPorAlunoId(aluno.getIdAluno());
        List<Horario> horarios = new ArrayList<>();

        for (Turma turma : turmas) {
            horarios.addAll(_horarioRepository.getPorTurmaId(turma.getIdTurma()));
        }

        List<HorarioLinha> horariosLinha = criarTemplateDeLinhas();
        Map<LocalTime, HorarioLinha> mapLinha = new HashMap<>();
        for (HorarioLinha horarioLinha : horariosLinha) {
            mapLinha.put(horarioLinha.getHoraInicio(), horarioLinha);
        }

        for(Horario horario : horarios) {
            addHorario(mapLinha.get(horario.getHorarioInicio()), horario);
        }

        List<ProximosHorarios> proximosHorarios = new ArrayList<>();

        List<Horario> horarios1 = _horarioRepository.getProximosPorTurmas(turmas);
        for(Horario horario : horarios1) {
            proximosHorarios.add(new ProximosHorarios(horario));
        }

        model.addAttribute("proximosHorarios", proximosHorarios);
        model.addAttribute("horariosLinha", horariosLinha);
        model.addAttribute("turmas", turmas);
        return "agenda/index";
    }

    private void addHorario(HorarioLinha linha, Horario horario) {
        linha.setVisivel(true);
        switch (horario.getDiaDaSemana()) {
            case 1:
                linha.setDomingo(horario);
                break;
            case 2:
                linha.setSegunda(horario);
                break;
            case 3:
                linha.setTerca(horario);
                break;
            case 4:
                linha.setQuarta(horario);
                break;
            case 5:
                linha.setQuinta(horario);
                break;
            case 6:
                linha.setSexta(horario);
                break;
            case 7:
                linha.setSabado(horario);
                break;
        }
    }

    private List<HorarioLinha> criarTemplateDeLinhas() {
        List<HorarioLinha> linhas = new ArrayList<>();

        linhas.add(new HorarioLinha(LocalTime.of(8, 0), "08:00 - 08:50",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(8, 50), "08:50 - 09:40",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(9, 40), "09:40 - 10:00",false, true, null, null, null, null, null, null, null)); // Intervalo
        linhas.add(new HorarioLinha(LocalTime.of(10, 0), "10:00 - 10:50",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(10, 50), "10:50 - 11:40",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(11, 40), "11:40 - 13:00",false,true, null, null, null, null, null, null, null)); // Intervalo
        linhas.add(new HorarioLinha(LocalTime.of(13, 0), "13:00 - 13:50",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(13, 50), "13:50 - 14:40",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(14, 40), "14:40 - 15:00",false,true, null, null, null, null, null, null, null)); // Intervalo
        linhas.add(new HorarioLinha(LocalTime.of(15, 0), "15:00 - 15:50",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(15, 50), "15:50 - 16:40",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(16, 40), "16:40 - 17:00",false,true, null, null, null, null, null, null, null)); // Intervalo
        linhas.add(new HorarioLinha(LocalTime.of(17, 0), "17:00 - 17:50",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(17, 50), "17:50 - 18:40",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(18, 40), "18:40 - 19:00",false,true, null, null, null, null, null, null, null)); // Intervalo
        linhas.add(new HorarioLinha(LocalTime.of(19, 0), "19:00 - 19:50",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(19, 50), "19:50 - 20:40",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(20, 40), "20:40 - 21:00",false, true,null, null, null, null, null, null, null)); // Intervalo
        linhas.add(new HorarioLinha(LocalTime.of(21, 0), "21:00 - 21:50",false, null, null, null, null, null, null, null));
        linhas.add(new HorarioLinha(LocalTime.of(21, 50), "21:50 - 22:40", false, null, null, null, null, null, null, null));

        return linhas;
    }
}
