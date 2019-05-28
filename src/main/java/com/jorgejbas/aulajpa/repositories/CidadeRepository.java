package com.jorgejbas.aulajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgejbas.aulajpa.domain.Cidade;
import com.jorgejbas.aulajpa.domain.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{


	
}

