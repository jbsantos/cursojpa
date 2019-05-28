package com.jorgejbas.aulajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgejbas.aulajpa.domain.Endereco;
//import com.jorgejbas.aulajpa.domain.Cliente;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	
}

