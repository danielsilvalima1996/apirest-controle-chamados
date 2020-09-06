package com.apirest.chamados.specification;

import org.springframework.data.jpa.domain.Specification;

import com.apirest.chamados.model.Tecnico;

public class TecnicoSpecification {

	public static Specification<Tecnico> idTecnico(Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}


	public static Specification<Tecnico> nomeCompletoTecnico(String nomeCompleto) {
		if (nomeCompleto == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("nomeCompleto")), "%" + nomeCompleto + "%");
	}
	
	public static Specification<Tecnico> emailTecnico(String email) {
		if (email == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("email")), "%" + email + "%");
	}

	public static Specification<Tecnico> ativoTecnico(Boolean ativo) {
		if (ativo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ativo"), ativo);
	}

}
