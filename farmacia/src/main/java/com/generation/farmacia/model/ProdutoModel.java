package com.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	
	private long id;
	
	@NotNull
	private String consumidor;
	//nome do consumidor
	
	private String tipo ;
	//vai definir se é de gotas,de comprimido, etc.
	
	@ManyToOne
	//não precisa de outro parâmetro
	@JsonIgnoreProperties("produto")
	//evitar recursividade, que só tem dentro das API, ele evita um loop, roda uma vez e depois ele para.
	//é feito no nome do objeto
	
	private List<CategoriaModel> categoria;
	//listar todos os itens que estão na minha categoria, fazendo uma fusão dos dados

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(String consumidor) {
		this.consumidor = consumidor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<CategoriaModel> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaModel> categoria) {
		this.categoria = categoria;
	}
	
	
	
	

}
