package com.apirest.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apirest.chamados.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
	
	public List<Tecnico> findAll(Specification<Tecnico> and);
	
	@Query(value = "SELECT * FROM tecnico u where u.id_usuario = :id", nativeQuery = true )
	public Tecnico findByIdUsuario(@Param("id") Long id);
	
//	@Query(value = "SELECT * FROM analista u "
//			+ "WHERE u.id = :id "
//			+ "order by id",
//			nativeQuery = true)
//	Page<Analista> findId(@Param("id") String id, Pageable pageable);
	
}
