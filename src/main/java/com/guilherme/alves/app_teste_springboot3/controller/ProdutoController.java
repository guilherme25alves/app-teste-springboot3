package com.guilherme.alves.app_teste_springboot3.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilherme.alves.app_teste_springboot3.model.Produto;
import com.guilherme.alves.app_teste_springboot3.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {

        Produto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);

        // Versão antes de implementar tratamento global de Exceptions
        // com GlobalExceptinHandler.java e @RestControllerAdvice
        // try {
        // Produto produto = produtoService.buscarPorId(id);
        // return ResponseEntity.ok(produto);
        // } catch (RecursoNaoEncontradoException e) {
        // return ResponseEntity.status(HttpStatus.NOT_FOUND)
        // .body(e.getMessage());
        // }

        // Versão quando buscarPorId retornava Optional (antes de lançar Exception)
        // return produtoService.buscarPorId(id)
        // .map(ResponseEntity::ok)
        // .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

}
