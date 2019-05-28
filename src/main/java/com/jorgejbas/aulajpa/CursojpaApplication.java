package com.jorgejbas.aulajpa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jorgejbas.aulajpa.domain.Categoria;
import com.jorgejbas.aulajpa.domain.Produto;
import com.jorgejbas.aulajpa.repositories.CategoriaRepository;
import com.jorgejbas.aulajpa.repositories.ProdutoRepository;


@SpringBootApplication
public class CursojpaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	public static void main(String[] args) {
		SpringApplication.run(CursojpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		int indice = 0;
		Categoria cat1 = new Categoria(0,"Informática");
		Categoria cat2 = new Categoria (0,"escritório");
		
		Produto p1 = new Produto(1, "Computador", 2000.00);
		Produto p2 = new Produto(2, "Impressora", 800.00);
		Produto p3 = new Produto(3, "Mause", 80.00);
		
		cat1.getProduto().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProduto().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtorepository.save(Arrays.asList(p1,p2,p3));
		
	}

}

























