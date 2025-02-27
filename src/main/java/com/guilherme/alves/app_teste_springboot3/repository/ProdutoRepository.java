package com.guilherme.alves.app_teste_springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.alves.app_teste_springboot3.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
