package com.eduacsp.test.calcplanos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Preco {

	@Id
	@GeneratedValue
	private Long id;
	private String origem;
	private String destino;
	
	@Column(name="valor_min")
	private BigDecimal valorMin;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public BigDecimal getValorMin() {
		return valorMin;
	}
	public void setValorMin(BigDecimal valorMin) {
		this.valorMin = valorMin;
	}
	
	
	@Override
	public String toString() {
		return "Precos [id=" + id + ", origem=" + origem + ", destino=" + destino + ", valorMin=" + valorMin + "]";
	}
	
	

	
	
	
}
