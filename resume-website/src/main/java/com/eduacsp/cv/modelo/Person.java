package com.eduacsp.cv.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person implements Serializable{

	private static final long serialVersionUID = -1837094451358665106L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_person")
	private Long idPerson;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cpf")
	private String cpf;
	
	@OneToMany(mappedBy = "person", targetEntity = Cv.class, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Column(name="cv")
	private Set<Cv> cv;
	
	@OneToMany(mappedBy = "person", targetEntity = Contact.class, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Column(name="contact")
	private Set<Contact> contact;
	
	
	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Cv> getCv() {
		return cv;
	}

	public void setCv(Set<Cv> cv) {
		this.cv = cv;
	}

	public Set<Contact> getContact() {
		return contact;
	}

	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}

	
	
	
}
