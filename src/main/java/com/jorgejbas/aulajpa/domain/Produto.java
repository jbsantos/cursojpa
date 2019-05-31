package com.jorgejbas.aulajpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomme;
	private Double preco;
	
	//Muito para mauitos JoinTable da o nome para a tabela gerada no relacionamento
	@JsonIgnore
	@ManyToMany
	@JoinTable( name = "PRODUTO_CATEGORIA",
		joinColumns = @JoinColumn(name = "produto_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id")
			)
	@Autowired
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	
	public Produto() {
		
	}
	
	
	public Produto(Integer id, String nomme, Double preco) {
		super();
		this.id = id;
		this.nomme = nomme;
		this.preco = preco;
			
	}
	@JsonIgnore
	public List<Pedido> getPedidos() {
		
		List<Pedido> lista = new ArrayList<>()	;
			for (ItemPedido x : itens){
		lista.add(x.getPedido());
			}
			return lista;
	}
	
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	
	public Set<ItemPedido> getItens() {
		return itens;
	}



	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}



	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNomme() {
		return nomme;
	}



	public void setNomme(String nomme) {
		this.nomme = nomme;
	}



	public Double getPreco() {
		return preco;
	}



	public void setPreco(Double preco) {
		this.preco = preco;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
