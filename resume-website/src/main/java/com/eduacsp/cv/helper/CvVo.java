package com.eduacsp.cv.helper;

import com.eduacsp.cv.modelo.Cv;
import com.eduacsp.cv.modelo.Person;

public class CvVo {
	
	private Cv cv;
	
	private Person person;
	
	private String expireDate;
	
	private String locale;
	
	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	

}
