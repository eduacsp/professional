package com.eduacsp.cv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eduacsp.cv.modelo.Cv;
import com.eduacsp.cv.modelo.EnumIdiom;
import com.eduacsp.cv.modelo.Person;

@Repository
public interface CvRepository extends CrudRepository<Cv, Long>{
	
	@Query("select c from Cv c where c.idiom = :idiom")
    public List<Cv> listarCv(@Param("idiom") EnumIdiom idiom);
	
	
	@Query("select c from Person c where c.idPerson=1")
    public List<Person> listarPerson();
	
	
}
