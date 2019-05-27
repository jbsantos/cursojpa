package com.jorgejbas.aulajpa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgejbas.aulajpa.domain.Categoria;
import com.jorgejbas.aulajpa.repositories.CategoriaRepository;


@Service
public class CategoriaService {

/* Instancia o repositório criado em repositories pela notação JpaRepository*/	
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		
		Categoria obj = repo.findOne(id);
		return obj;
		
	}
}
