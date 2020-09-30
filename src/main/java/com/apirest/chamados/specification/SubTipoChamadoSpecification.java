package com.apirest.chamados.specification;

import org.springframework.data.jpa.domain.Specification;

import com.apirest.chamados.model.SubTipoChamado;

public class SubTipoChamadoSpecification {
	
	public static Specification<com.apirest.chamados.model.SubTipoChamado> idSubTipoChamado(Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public static Specification<SubTipoChamado> descricaoSubTipoChamado(String descricao) {
		if (descricao == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("descricao")), "%" + descricao + "%");
	}


	public static Specification<SubTipoChamado> ativoSubTipoChamado(Boolean ativo) {
		if (ativo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ativo"), ativo);
	}

	public static Specification<SubTipoChamado> idTipoChamadoSubtipoChamado(Long idTipoChamado) {
		if (idTipoChamado == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idTipoChamado"), idTipoChamado);
	}

}
