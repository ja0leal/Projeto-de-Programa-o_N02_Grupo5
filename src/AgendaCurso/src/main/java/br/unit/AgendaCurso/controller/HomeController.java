package br.unit.AgendaCurso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Este é um Controller MVC.
 * A anotação @Controller diz ao Spring que esta classe
 * retornará nomes de Views (templates HTML), e não JSON.
 */
@Controller
public class HomeController {

    /**
     * Mapeia requisições HTTP GET para a raiz do site ("/").
     */
    @GetMapping("/")
    public String index() {
        // Esta string "index" é o nome do arquivo HTML
        // que o Thymeleaf deve renderizar.
        return "index";
    }
}