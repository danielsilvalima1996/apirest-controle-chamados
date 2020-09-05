package com.apirest.chamados.specification;

import org.springframework.data.jpa.domain.Specification;

import com.apirest.chamados.model.Usuario;

public class UsuarioSpecification {

	public static Specification<Usuario> idUsuario(Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public static Specification<Usuario> emailUsuario(String email) {
		if (email == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("email")), "%" + email + "%");
	}

	public static Specification<Usuario> nomeCompletoUsuario(String nomeCompleto) {
		if (nomeCompleto == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("nomeCompleto")), "%" + nomeCompleto + "%");
	}

	public static Specification<Usuario> ativoUsuario(Boolean ativo) {
		if (ativo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ativo"), ativo);
	}

	public static Specification<Usuario> idRegraUsuario(Long idRegra) {
		if (idRegra == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idRegra"), idRegra);
	}

	public static Specification<Usuario> idEmpresaUsuario(Long idEmpresa) {
		if (idEmpresa == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("idEmpresa"), idEmpresa);
	}

	public static Specification<Usuario> isTecnicoUsuario(Boolean isTecnico) {
		if (isTecnico == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("isTecnico"), isTecnico);
	}

}
