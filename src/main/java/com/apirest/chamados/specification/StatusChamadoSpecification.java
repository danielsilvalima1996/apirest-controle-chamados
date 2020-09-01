package com.apirest.chamados.specification;

import org.springframework.data.jpa.domain.Specification;

import com.apirest.chamados.model.StatusChamado;

public class StatusChamadoSpecification {
	
	public static Specification<com.apirest.chamados.model.StatusChamado> idStatusChamado(Long id) {
	if (id == null) {
		return null;
	}
	return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
}

public static Specification<StatusChamado> descricaoStatusChamado(String descricao) {
	if (descricao == null) {
		return null;
	}
	return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
			.like(criteriaBuilder.lower(root.<String>get("descricao")), "%" + descricao + "%");
}

public static Specification<StatusChamado> corStatusChamado(String cor) {
	if (cor == null) {
		return null;
	}
	return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
			.like(criteriaBuilder.lower(root.<String>get("cor")), "%" + cor + "%");
}

public static Specification<StatusChamado> ativoStatusChamado(Boolean ativo) {
	if (ativo == null) {
		return null;
	}
	return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ativo"), ativo);
}
}
