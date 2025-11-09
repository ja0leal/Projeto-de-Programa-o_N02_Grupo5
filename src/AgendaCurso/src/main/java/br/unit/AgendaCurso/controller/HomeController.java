package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.models.Professor;
import br.unit.AgendaCurso.repositories.ProfessoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProfessoresRepository _professoresRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Professor> pList = _professoresRepository.getTodos();
        model.addAttribute("Professores", pList);

        return "index";
    }


}