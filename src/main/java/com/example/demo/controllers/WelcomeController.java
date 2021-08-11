package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String hello(Model model, @RequestParam(value = "nome", required = false, defaultValue = "you") String nome) {
        model.addAttribute("nome", nome);
        return "index";
    }
}