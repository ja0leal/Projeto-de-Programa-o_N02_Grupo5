package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.models.Teste;
import br.unit.AgendaCurso.repositories.AlunosRepository;
import br.unit.AgendaCurso.repositories.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProfessoresRepository _professoresRepository;
    @Autowired
    private AlunosRepository _alunosRepository;

    @GetMapping("/")
    public String index(Principal principal, Model model) {
        if(principal == null){
            return "index";
        }
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula).orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));

        model.addAttribute("alunoLogado", aluno);
        return "index";
    }

    @GetMapping("/Sobre")
    public String sobre(Principal principal, Model model) {
        if(principal == null){
            return "index";
        }
        String matricula = principal.getName();
        Aluno aluno = _alunosRepository.getPorMatricula(matricula).orElseThrow(() -> new RuntimeException("Aluno logado não encontrado"));

        model.addAttribute("alunoLogado", aluno);
        return "home/sobre";
    }
}