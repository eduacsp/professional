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

@Entity
@Table(name="contact")
public class Contact implements Serializable{

	private static final long serialVersionUID = -7422968828950742396L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_contact")
	private Long idContact;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private EnumContactType type;
	
	@Column(name="text")
	private String text;
	
	@Column(name="label")
	private String label;
	
	@ManyToOne
	@JoinColumn(name="id_person", referencedColumnName="id_person")
	private Person person;
	
		
	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

	public EnumContactType getType() {
		return type;
	}

	public void setType(EnumContactType type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}


	
	
}
