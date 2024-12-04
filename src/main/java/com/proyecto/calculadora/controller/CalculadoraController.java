package com.proyecto.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("calculadora")
public class CalculadoraController {
    @GetMapping
    public String index(Model modelo) {
        modelo.addAttribute("title", "BIENVENIDO A LA CALCULADORA");
        return "calculadora/form";
    }

    @PostMapping
    public String postMethodName(@RequestParam("nombreUser") String name, Model modelo) {
        modelo.addAttribute("name", name);
        return "calculadora/welcome";
    }

}
