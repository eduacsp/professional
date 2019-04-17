package com.eduacsp.test.calcplanos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plano {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Integer codigo;
	
	private String nome;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Plano [id=" + id + ", codigo=" + codigo + ", nome=" + nome + "]";
	}
	

	
	
	

}
