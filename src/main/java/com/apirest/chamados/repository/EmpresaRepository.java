package com.apirest.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.chamados.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	public List<Empresa> findAll(Specification<Empresa> and);
	
	public Empresa findByCnpj(String cnpj);

}
