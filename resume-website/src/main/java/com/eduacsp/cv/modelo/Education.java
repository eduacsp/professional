package com.eduacsp.cv.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
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

@Entity
@Table(name="education")
public class Education implements Serializable{

	private static final long serialVersionUID = 5296228004357661052L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_education")
	private Long idEducation;
	
	@Column(name="institution_name")
	private String institutionName;
	
	@Column(name="course_name")
	private String courseName;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="from_date")
	private Date fromDate;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="to_date")
	private Date toDate;
	
	@ManyToOne
	@JoinColumn(name="id_cv", referencedColumnName="id_cv")
	private Cv cv;
	
	@Transient
	private String fromDateF;
	
	@Transient
	private String toDateF;
	
	public Long getIdEducation() {
		return idEducation;
	}

	public void setIdEducation(Long idEducation) {
		this.idEducation = idEducation;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEducation == null) ? 0 : idEducation.hashCode());
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
		Education other = (Education) obj;
		if (idEducation == null) {
			if (other.idEducation != null)
				return false;
		} else if (!idEducation.equals(other.idEducation))
			return false;
		return true;
	}
	
	
		
	

}
