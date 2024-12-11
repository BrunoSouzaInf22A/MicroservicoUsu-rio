package com.projeto.microservico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testeController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Swagger!";
    }
}
