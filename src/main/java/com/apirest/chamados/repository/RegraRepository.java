package com.apirest.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.chamados.model.Regra;

public interface RegraRepository extends JpaRepository<Regra, Long> {
	
	public List<Regra> findAll(Specification<Regra> and);

}
