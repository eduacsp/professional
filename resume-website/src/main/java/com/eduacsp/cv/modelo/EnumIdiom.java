package com.eduacsp.cv.modelo;

public enum EnumIdiom {
	PORTUGUES("PORTUGUES"),
	ENGLISH("ENGLISH");
	
	private String value;
	
	EnumIdiom(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}