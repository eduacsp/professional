package com.eduacsp.cv.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="cv")
public class Cv implements Serializable{

	private static final long serialVersionUID = -1081181827200698662L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cv")
	private Long idCv;

	@Column(name="name")
	private String name;

	@Column(name="role")
	private String role;

	@Column(name="career_profile_title")
	private String careerProfileTitle;

	@Column(name="career_profile_text")
	@Size(max = 21844)
	private String careerProfileText;

	@Column(name="education_title")
	private String educationTitle;
	
	@Column(name="interests_title")
	private String interestsTitle;
	
	@Column(name="language_title")
	private String languageTitle;
	
	@Column(name="experiences_title")
	private String experiencesTitle;
	
	@Column(name="skills_title")
	private String skillsTitle;

	@OneToMany(mappedBy = "cv", targetEntity = Experience.class, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Column(name="experience")
	private Set<Experience> experience;

	@OneToMany(mappedBy = "cv", targetEntity = Skill.class, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Column(name="skill")
	private Set<Skill> skill;

	@OneToMany(mappedBy = "cv", targetEntity = Education.class, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Column(name="education")
	private Set<Education> education;

	@OneToMany(mappedBy = "cv", targetEntity = Language.class, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Column(name="language")
	private Set<Language> language;

	@OneToMany(mappedBy = "cv", targetEntity = Interest.class, cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@Column(name="interest")
	private Set<Interest> interest;
	
	@Enumerated(EnumType.STRING)
	@Column(name="idiom")
	private EnumIdiom idiom;
	
	@ManyToOne
	@JoinColumn(name="id_person", referencedColumnName="id_person")
	private Person person;

	public Long getIdCv() {
		return idCv;
	}

	public void setIdCv(Long idCv) {
		this.idCv = idCv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCareerProfileTitle() {
		return careerProfileTitle;
	}

	public void setCareerProfileTitle(String careerProfileTitle) {
		this.careerProfileTitle = careerProfileTitle;
	}

	public String getCareerProfileText() {
		return careerProfileText;
	}

	public void setCareerProfileText(String careerProfileText) {
		this.careerProfileText = careerProfileText;
	}

	public String getExperiencesTitle() {
		return experiencesTitle;
	}

	public void setExperiencesTitle(String experiencesTitle) {
		this.experiencesTitle = experiencesTitle;
	}

	public Set<Experience> getExperience() {
		return experience;
	}

	public void setExperience(Set<Experience> experience) {
		this.experience = experience;
	}

	
	public String getSkillsTitle() {
		return skillsTitle;
	}

	public void setSkillsTitle(String skillsTitle) {
		this.skillsTitle = skillsTitle;
	}

	public EnumIdiom getIdiom() {
		return idiom;
	}

	public void setIdiom(EnumIdiom idiom) {
		this.idiom = idiom;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<Education> getEducation() {
		return education;
	}

	public void setEducation(Set<Education> education) {
		this.education = education;
	}

	public Set<Language> getLanguage() {
		return language;
	}

	public void setLanguage(Set<Language> language) {
		this.language = language;
	}

	public Set<Interest> getInterest() {
		return interest;
	}

	public void setInterest(Set<Interest> interest) {
		this.interest = interest;
	}

	public Set<Skill> getSkill() {
		return skill;
	}

	public void setSkill(Set<Skill> skill) {
		this.skill = skill;
	}

	public String getEducationTitle() {
		return educationTitle;
	}

	public void setEducationTitle(String educationTitle) {
		this.educationTitle = educationTitle;
	}

	public String getInterestsTitle() {
		return interestsTitle;
	}

	public void setInterestsTitle(String interestsTitle) {
		this.interestsTitle = interestsTitle;
	}

	public String getLanguageTitle() {
		return languageTitle;
	}

	public void setLanguageTitle(String languageTitle) {
		this.languageTitle = languageTitle;
	}

	




}
