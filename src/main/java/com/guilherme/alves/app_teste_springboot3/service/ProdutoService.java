package com.guilherme.alves.app_teste_springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guilherme.alves.app_teste_springboot3.exceptions.RecursoNaoEncontradoException;
import com.guilherme.alves.app_teste_springboot3.model.Produto;
import com.guilherme.alves.app_teste_springboot3.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final String MSG_PRODUTO_NOT_FOUND = "Produto com ID %s não encontrado";

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(
                        () -> new RecursoNaoEncontradoException(String.format(MSG_PRODUTO_NOT_FOUND, id)));
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {

        if (!produtoRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException(String.format(MSG_PRODUTO_NOT_FOUND, id));
        }

        produtoRepository.deleteById(id);
    }

}
