package com.apirest.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.chamados.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public List<Usuario> findAll(Specification<Usuario> and);
	
	public Usuario findByEmail(String email);
	

}
