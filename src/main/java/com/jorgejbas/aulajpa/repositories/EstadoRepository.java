package com.jorgejbas.aulajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jorgejbas.aulajpa.domain.Estado;
import com.jorgejbas.aulajpa.domain.Cidade;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

	
}

