package com.guilherme.alves.app_teste_springboot3.service;

import org.springframework.stereotype.Service;

import com.guilherme.alves.app_teste_springboot3.repository.MensagemRepository;

@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    public String obterMensagem() {
        return mensagemRepository.obterMensagem();
    }
}
