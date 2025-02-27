package com.guilherme.alves.app_teste_springboot3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/h")
    public String hello() {
        return "Olá, iniciando com Spring Boot";
    }

}
