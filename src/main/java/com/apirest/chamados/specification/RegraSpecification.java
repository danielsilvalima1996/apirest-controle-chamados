package com.apirest.chamados.specification;

import org.springframework.data.jpa.domain.Specification;

import com.apirest.chamados.model.Regra;

public class RegraSpecification {

	public static Specification<com.apirest.chamados.model.Regra> idRegra(Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public static Specification<Regra> descricaoRegra(String descricao) {
		if (descricao == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("descricao")), "%" + descricao + "%");
	}

	public static Specification<Regra> ativoRegra(Boolean ativo) {
		if (ativo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ativo"), ativo);
	}

}
