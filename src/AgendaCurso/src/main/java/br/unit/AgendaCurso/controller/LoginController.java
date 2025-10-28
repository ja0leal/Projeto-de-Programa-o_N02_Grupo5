package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.user.DTO.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage(){
        return "auth/login";
    }

    @GetMapping("/register/student")
    public String showRegisterPage(Model model){
        model.addAttribute("registerRequest", new RegisterRequest());

        return "auth/register";
    }
}
