package com.eduacsp.cv.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eduacsp.cv.modelo.Cv;
import com.eduacsp.cv.modelo.EnumIdiom;
import com.eduacsp.cv.modelo.Guest;
import com.eduacsp.cv.modelo.Person;

@Repository
@Transactional
public class CvDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Cv> listarCv(EnumIdiom idiom) {
		return manager.createQuery("select c from Cv c where c.idiom='"+idiom+"'",Cv.class).getResultList();
	}

	public List<Person> listarPerson() {
		return manager.createQuery("select c from Person c where c.idPerson=1",Person.class).getResultList();
	}

	public void insertGuestLog(Guest guest) {
		manager.persist(guest);
	}

	
}
