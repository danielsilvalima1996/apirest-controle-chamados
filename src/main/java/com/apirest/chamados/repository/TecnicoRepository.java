package com.apirest.chamados.repository;

import java.util.List;

import com.apirest.chamados.model.Tecnico;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	
	public List<Tecnico> findAll(Specification<Tecnico> and);
	
	@Query(value = "SELECT * FROM tecnico u where u.id_usuario = :id", nativeQuery = true )
	public Tecnico findByIdUsuario(@Param("id") Long id);

}
