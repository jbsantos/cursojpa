package com.jorgejbas.aulajpa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgejbas.aulajpa.domain.Categoria;
import com.jorgejbas.aulajpa.repositories.CategoriaRepository;
import com.jorgejbas.aulajpa.services.exceptions.ObjetctNotFoundException;


@Service
public class CategoriaService {

/* Instancia o repositório criado em repositories pela notação JpaRepository*/	
	
	@Autowired
	private CategoriaRepository repo;
	@Autowired
	private CategoriaService objectnotfoundexception;
	
	public Categoria buscar(Integer id) {
		
		Categoria obj = repo.findOne(id);
		
		if (obj == null) {
			
			throw new ObjetctNotFoundException("objeto não encontrado! Id =" + id + " Tipo: " + Categoria.class.getName());
		}
		return obj;
		
	}

	public Categoria insert(Categoria obj) {

		obj.setId(null);;
		return repo.save(obj);
	}
}
