package com.eduacsp.test.calcplanos.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduacsp.test.calcplanos.model.Plano;

@Repository
public interface PlanoRepository extends JpaRepository<Plano, Long> {

	List<Plano> findAll(Sort sort);

	List<Plano> findByCodigo(Integer codigo);
	
}
