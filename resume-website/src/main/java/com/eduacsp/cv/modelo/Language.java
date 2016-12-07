package com.eduacsp.cv.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="language")
public class Language implements Serializable{

	private static final long serialVersionUID = 7627074936007460988L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_language")
	private Long idLanguage;
	
	@Column(name="name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name="language_proficiency")
	private EnumLanguageProficiency enumLanguageProficiency;
	
	@ManyToOne
	@JoinColumn(name="id_cv", referencedColumnName="id_cv")
	private Cv cv;
	
	@Transient
	private String languageProficiency;

	public Long getIdLanguage() {
		return idLanguage;
	}

	public void setIdLanguage(Long idLanguage) {
		this.idLanguage = idLanguage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EnumLanguageProficiency getEnumLanguageProficiency() {
		return enumLanguageProficiency;
	}

	public void setEnumLanguageProficiency(EnumLanguageProficiency enumLanguageProficiency) {
		this.enumLanguageProficiency = enumLanguageProficiency;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public String getLanguageProficiency() {
		return languageProficiency;
	}

	public void setLanguageProficiency(String languageProficiency) {
		this.languageProficiency = languageProficiency;
	}

	
	
	
}
