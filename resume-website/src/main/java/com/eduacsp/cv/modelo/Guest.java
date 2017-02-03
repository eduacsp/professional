package com.eduacsp.cv.modelo;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="guest")
public class Guest implements Serializable{

	private static final long serialVersionUID = -4628128560353146704L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_guest")
	private Long idGuest;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="user_agent")
	private String userAgent;
	
	@Column(name="referer")
	private String referer;
	
	@Column(name="idiom")
	private String idiom;
	
	@Column(name="city")
	private String city;
	
	@Column(name="region")
	private String region;
	
	@Column(name="country")
	private String country;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="date_insert")
	private Calendar dateInsert;
	
	public Long getIdGuest() {
		return idGuest;
	}

	public void setIdGuest(Long idGuest) {
		this.idGuest = idGuest;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getIdiom() {
		return idiom;
	}

	public void setIdiom(String idiom) {
		this.idiom = idiom;
	}

	public Calendar getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Calendar dateInsert) {
		this.dateInsert = dateInsert;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}



	
	
	
}
