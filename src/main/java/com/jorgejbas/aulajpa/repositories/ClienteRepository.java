package com.jorgejbas.aulajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgejbas.aulajpa.domain.Cliente;
//import com.jorgejbas.aulajpa.domain.Produto;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
}

