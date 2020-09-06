package com.apirest.chamados.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.chamados.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	
	public List<Tecnico> findAll(Specification<Tecnico> and);
	
	public Optional<Tecnico> findByEmail(String email);
	
}
