package com.eduacsp.cv.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.eduacsp.cv.modelo.Guest;

public class GuestRepositoryCustomImpl implements GuestRepositoryCustom{

	@PersistenceContext
	private EntityManager em;


	@Override
	public Guest save(Guest guest) {
		em.persist(guest);
		return guest;
	}

}
