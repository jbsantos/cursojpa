package com.jorgejbas.aulajpa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	public Categoria find(Integer id) {
		
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

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		
		try {
			repo.delete(id);
			}
			
			catch(DataIntegrityViolationException e){
				
				throw new com.jorgejbas.aulajpa.services.exceptions.DataIntegrityViolationException("Não foi possível excluir uma categoria que possui produtos");
				
			}
		
		
	}
}
