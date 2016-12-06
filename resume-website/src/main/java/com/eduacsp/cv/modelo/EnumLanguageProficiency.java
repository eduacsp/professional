package com.eduacsp.cv.modelo;

public enum EnumLanguageProficiency {
	NATIVE("Native"),
	FLUENT("Fluent"),
	TECHNICAL("Technical"),
	PROFESSIONAL("Professional");
	
	private String value;
	
	EnumLanguageProficiency(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}