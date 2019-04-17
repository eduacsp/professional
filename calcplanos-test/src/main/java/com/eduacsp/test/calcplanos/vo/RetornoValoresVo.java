package com.eduacsp.test.calcplanos.vo;

import java.math.BigDecimal;
import java.util.List;

public class RetornoValoresVo {

	private String origem;
	
	private String destino;
	
	private Integer tempo;
	
	private String plano;
	
	private BigDecimal comFaleMais;
	
	private BigDecimal semFaleMais;
	
	private List<String> listErros;
	

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

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public BigDecimal getComFaleMais() {
		return comFaleMais;
	}

	public void setComFaleMais(BigDecimal comFaleMais) {
		this.comFaleMais = comFaleMais;
	}

	public BigDecimal getSemFaleMais() {
		return semFaleMais;
	}

	public void setSemFaleMais(BigDecimal semFaleMais) {
		this.semFaleMais = semFaleMais;
	}

	public List<String> getListErros() {
		return listErros;
	}

	public void setListErros(List<String> listErros) {
		this.listErros = listErros;
	}
	
	
	
	
}
