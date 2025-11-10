package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/Admim")
class AdminController {
    @Autowired
    private AlunosRepository _alunosRepository;
    @Autowired
    private DiciplinaRepository _diciplinaRepository;
    @Autowired
    private HorarioRepository _horarioRepository;
    @Autowired
    private TurmaRepository _turmaRepository;
    @Autowired
    private ProfessoresRepository _professoresRepository;

    @GetMapping("/Professor")
    public String professor(Principal principal, Model model) {
        if(principal == null){
            return "redirect:/login";
        }
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula).orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));
        if(!aluno.getRole().equals("admin")){
            return "redirect:/";
        }
        model.addAttribute("alunoLogado", aluno);

        List<Professor> professores = _professoresRepository.getTodos();
        model.addAttribute("professores", professores);
        return "admin/professor";
    }
}
