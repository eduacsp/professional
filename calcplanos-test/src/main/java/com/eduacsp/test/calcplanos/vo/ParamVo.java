package com.eduacsp.test.calcplanos.vo;

public class ParamVo {

	private String origem;
	
	private String destino;
	
	private Integer tempo;
	
	private String plano;
	
	
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
	
	
	@Override
	public String toString() {
		return "ParamVo [origem=" + origem + ", destino=" + destino + ", tempo=" + tempo + ", plano=" + plano + "]";
	}
	
	
	
	
}
