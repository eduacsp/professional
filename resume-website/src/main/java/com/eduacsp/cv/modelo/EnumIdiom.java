package com.eduacsp.cv.modelo;

public enum EnumIdiom {
	PORTUGUES("Português"),
	ENGLISH("English");
	
	private String value;
	
	EnumIdiom(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}