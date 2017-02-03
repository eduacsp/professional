package com.eduacsp.cv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eduacsp.cv.modelo.Guest;

@Repository
public interface GuestRepository<T> extends CrudRepository<Guest, Long>, GuestRepositoryCustom{
}
