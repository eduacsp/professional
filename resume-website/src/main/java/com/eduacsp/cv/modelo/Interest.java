package com.eduacsp.cv.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="interest")
public class Interest implements Serializable{

	private static final long serialVersionUID = 2256343328752218200L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_interest")
	private Long idInterest;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="id_cv", referencedColumnName="id_cv")
	private Cv cv;

	public Long getIdInterest() {
		return idInterest;
	}

	public void setIdInterest(Long idInterest) {
		this.idInterest = idInterest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	

	
}
