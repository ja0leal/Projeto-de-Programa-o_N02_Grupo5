package br.unit.AgendaCurso.controller;

import br.unit.AgendaCurso.user.DTO.RegisterRequest;
import br.unit.AgendaCurso.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register/student")
    public String processRegister(@Valid
                                  @ModelAttribute("registerRequest")
                                      RegisterRequest registerRequest,
                                  BindingResult result){
        if (result.hasErrors()) {
            return "auth/register";
        }

        try {
            userService.registerStudent(registerRequest.getName(),
                                        registerRequest.getEmail(),
                                        registerRequest.getPassword());

        } catch (IllegalArgumentException exception) {
            result.rejectValue("email", "email.exists", exception.getMessage());
            return "auth/register";
        }

        return "redirect:/login?success=true";
    }
}
