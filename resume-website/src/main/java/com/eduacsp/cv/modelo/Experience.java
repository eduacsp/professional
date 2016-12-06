package com.eduacsp.cv.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="experience")
public class Experience implements Serializable{

	private static final long serialVersionUID = 306477914771641857L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_experience")
	private Long idExperience;
	
	@Column(name="role_title")
	private String roleTitle;
	
	@Column(name="company")
	private String company;
	
	@Column(name="location")
	private String location;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
	
	@Convert(converter=BooleanToYNStringConverter.class)
	@Column(name="until_now", length=1)
	private boolean untilNow;
	
	@Column(name="text")
	@Size(max = 21844)
	private String text;
		
	@ManyToOne
	@JoinColumn(name="id_cv", referencedColumnName="id_cv")
	private Cv cv;
	
	@Transient
	private String fromDateF;
	
	@Transient
	private String toDateF;
	
	@Transient
	private String untilNowIdiom;

	public Long getIdExperience() {
		return idExperience;
	}

	public void setIdExperience(Long idExperience) {
		this.idExperience = idExperience;
	}

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public boolean isUntilNow() {
		return untilNow;
	}

	public void setUntilNow(boolean untilNow) {
		this.untilNow = untilNow;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public String getFromDateF() {
		return fromDateF;
	}

	public void setFromDateF(String fromDateF) {
		this.fromDateF = fromDateF;
	}

	public String getToDateF() {
		return toDateF;
	}

	public void setToDateF(String toDateF) {
		this.toDateF = toDateF;
	}
	
	public String getUntilNowIdiom() {
		return untilNowIdiom;
	}

	public void setUntilNowIdiom(String untilNowIdiom) {
		this.untilNowIdiom = untilNowIdiom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experience other = (Experience) obj;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		return true;
	}

	
	
	

}
