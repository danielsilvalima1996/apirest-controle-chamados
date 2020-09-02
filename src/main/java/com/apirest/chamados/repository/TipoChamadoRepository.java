package com.apirest.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.chamados.model.TipoChamado;

public interface TipoChamadoRepository extends JpaRepository<TipoChamado, Long> {
	
	public List<TipoChamado> findAll(Specification<TipoChamado> and);

}
