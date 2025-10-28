package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.user.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String showDashboardPage(Model model, @AuthenticationPrincipal User userDetails){
        model.addAttribute("nomeDoUsuario", userDetails.getName());

        model.addAttribute("emailDoUsuario", userDetails.getEmail());

        return "dashboard/index";
    }
}
