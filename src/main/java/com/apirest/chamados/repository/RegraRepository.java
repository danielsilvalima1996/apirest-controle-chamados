package com.apirest.chamados.repository;

import java.util.List;

import com.apirest.chamados.model.Regra;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegraRepository extends JpaRepository<Regra, Long> {
	
	public List<Regra> findAll(Specification<Regra> and);
	
	public Regra findByDescricao(String descricao);

}
