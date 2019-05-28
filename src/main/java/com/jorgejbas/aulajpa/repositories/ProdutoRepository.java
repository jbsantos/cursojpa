package com.jorgejbas.aulajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgejbas.aulajpa.domain.Produto;
import com.jorgejbas.aulajpa.domain.Categoria;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	
}