package com.guilherme.alves.app_teste_springboot3.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {

    public String obterMensagem() {
        return "Oi do repositório";
    }
}
