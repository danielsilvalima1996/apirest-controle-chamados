package com.apirest.chamados.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.chamados.model.SubTipoChamado;

public interface SubTipoChamadoRepository extends JpaRepository<SubTipoChamado,Long> {

	public List<SubTipoChamado> findAll(Specification<SubTipoChamado> and);
}
