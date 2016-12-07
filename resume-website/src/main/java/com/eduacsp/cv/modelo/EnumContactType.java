package com.eduacsp.cv.modelo;

public enum EnumContactType {
	EMAIL("Email"),
	TELEFONE("Telefone"),
	LINKEDIN("Linkedin"),
	GITHUB("Github"),
	TWITTER("Twitter");
	
	private String value;
	
	EnumContactType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}