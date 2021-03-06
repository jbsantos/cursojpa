package com.jorgejbas.aulajpa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jorgejbas.aulajpa.domain.Cliente;
import com.jorgejbas.aulajpa.services.ClienteService;

@RestController

@RequestMapping(value="/clientes", method=RequestMethod.GET)
public class ClienteResources {

	/*Instance o ClienteService*/
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		
		Cliente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
		

		
	}
	
}
