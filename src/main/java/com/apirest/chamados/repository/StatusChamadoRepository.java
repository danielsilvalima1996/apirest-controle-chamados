package com.apirest.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.chamados.model.StatusChamado;

public interface StatusChamadoRepository extends JpaRepository<StatusChamado, Long> {
	
	public List<StatusChamado> findAll(Specification<StatusChamado> and);

}
