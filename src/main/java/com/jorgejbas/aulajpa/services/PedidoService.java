package com.jorgejbas.aulajpa.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jorgejbas.aulajpa.domain.Pedido;
import com.jorgejbas.aulajpa.repositories.PedidoRepository;
import com.jorgejbas.aulajpa.services.exceptions.ObjetctNotFoundException;


@Service
public class PedidoService {

/* Instancia o repositório criado em repositories pela notação JpaRepository*/	
	
	@Autowired
	private PedidoRepository repo;
	@Autowired
	private PedidoService objectnotfoundexception;
	
	public Pedido find(Integer id) {
		
		Pedido obj = repo.findOne(id);
		
		if (obj == null) {
			
			throw new ObjetctNotFoundException("objeto não encontrado! Id =" + id + " Tipo: " + Pedido.class.getName());
		}
		return obj;
		
	}
}
