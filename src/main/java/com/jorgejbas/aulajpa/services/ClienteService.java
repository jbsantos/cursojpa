package com.jorgejbas.aulajpa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgejbas.aulajpa.domain.Cliente;
import com.jorgejbas.aulajpa.repositories.ClienteRepository;
import com.jorgejbas.aulajpa.services.exceptions.ObjetctNotFoundException;


@Service
public class ClienteService {

/* Instancia o repositório criado em repositories pela notação JpaRepository*/	
	
	@Autowired
	private ClienteRepository repo;
	@Autowired
	private ClienteService objectnotfoundexception;
	
	public Cliente buscar(Integer id) {
		
		Cliente obj = repo.findOne(id);
		
		if (obj == null) {
			
			throw new ObjetctNotFoundException("objeto não encontrado! Id =" + id + " Tipo: " + Cliente.class.getName());
		}
		return obj;
		
	}
}
