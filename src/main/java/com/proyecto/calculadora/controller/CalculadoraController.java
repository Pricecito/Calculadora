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

    @PostMapping("/login")
    public String login(@RequestParam("nombreUser") String name, Model modelo) {
        modelo.addAttribute("name", name);
        return "calculadora/welcome";
    }

    @PostMapping("/operar")
    public String suma(@RequestParam("num1") int n1, @RequestParam("num2") int n2,
            @RequestParam("operation") String operation, Model modelo) {
        Object result;
        switch (operation) {
            case "suma":
                result = n1 + n2;
                break;
            case "resta":
                result = n1 - n2;
                break;
            case "multiplicacion":
                result = n1 * n2;
                break;
            default:
                result = Math.round(n1 / n2);
        }
        ;
        modelo.addAttribute("result", result);
        return "calculadora/welcome";
    }
}
