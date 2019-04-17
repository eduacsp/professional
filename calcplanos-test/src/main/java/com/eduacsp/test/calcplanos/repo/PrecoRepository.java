package com.eduacsp.test.calcplanos.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduacsp.test.calcplanos.model.Preco;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {
	
	List<Preco> findAll();

	List<Preco> findByOrigemAndDestino(String origem, String destino);

}
