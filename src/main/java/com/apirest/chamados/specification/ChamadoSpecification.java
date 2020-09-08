package com.apirest.chamados.specification;

import com.apirest.chamados.model.Chamado;

import org.springframework.data.jpa.domain.Specification;

public class ChamadoSpecification {

	public static Specification<Chamado> idChamado(Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public static Specification<Chamado> idUsuarioChamado(Long idUsuario) {
		if (idUsuario == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idUsuario"), idUsuario);
	}

	public static Specification<Chamado> statusChamadoChamado(Integer statusChamado) {
		if (statusChamado == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("statusChamado"), statusChamado);
	}

	public static Specification<Chamado> idTipoChamadoChamado(Long idTipoChamado) {
		if (idTipoChamado == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idTipoChamado"), idTipoChamado);
	}

	public static Specification<Chamado> idSubtipoChamadoChamado(Long idSubtipoChamado) {
		if (idSubtipoChamado == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idSubtipoChamado"), idSubtipoChamado);
	}

	public static Specification<Chamado> idTecnicoChamado(Long idTecnico) {
		if (idTecnico == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idTecnico"), idTecnico);
	}

	public static Specification<Chamado> descricaoChamado(String descricao) {
		if (descricao == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("descricao")), "%" + descricao + "%");
	}

}
