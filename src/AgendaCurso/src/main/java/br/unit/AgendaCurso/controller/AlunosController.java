package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.models.Aluno;
import br.unit.AgendaCurso.repositories.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/Aluno")
class AlunosController {
    @Autowired
    private AlunosRepository _alunosRepository;

    @GetMapping("/Add")
    public String index(Model model) {
        Aluno aluno = new  Aluno("Marcos Eduardo", "22025000001", "eduardo@gmail.com", "1234", "Comum", 1){};
        _alunosRepository.addAluno(aluno);
        return "redirect:/";
    }
}
