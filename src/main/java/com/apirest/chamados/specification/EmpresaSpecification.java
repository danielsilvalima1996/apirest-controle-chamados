package com.apirest.chamados.specification;

import org.springframework.data.jpa.domain.Specification;

import com.apirest.chamados.model.Empresa;

public class EmpresaSpecification {

	public static Specification<Empresa> idEmpresa(Long id) {
		if (id == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
	}

	public static Specification<Empresa> cnpjEmpresa(String cnpj) {
		if (cnpj == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("cnpj")), "%" + cnpj + "%");
	}

	public static Specification<Empresa> razaoSocialEmpresa(String razaoSocial) {
		if (razaoSocial == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("razaoSocial")), "%" + razaoSocial + "%");
	}

	public static Specification<Empresa> nomeFantasiaEmpresa(String nomeFantasia) {
		if (nomeFantasia == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("nomeFantasia")), "%" + nomeFantasia + "%");
	}

	public static Specification<Empresa> ativoEmpresa(Boolean ativo) {
		if (ativo == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("ativo"), ativo);
	}

	public static Specification<Empresa> cepEmpresa(String cep) {
		if (cep == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("cep")), "%" + cep + "%");
	}

	public static Specification<Empresa> logradouroEmpresa(String logradouro) {
		if (logradouro == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("logradouro")), "%" + logradouro + "%");
	}

	public static Specification<Empresa> bairroEmpresa(String bairro) {
		if (bairro == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("bairro")), "%" + bairro + "%");
	}

	public static Specification<Empresa> localidadeEmpresa(String localidade) {
		if (localidade == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("localidade")), "%" + localidade + "%");
	}

	public static Specification<Empresa> ufEmpresa(String uf) {
		if (uf == null) {
			return null;
		}
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
				.like(criteriaBuilder.lower(root.<String>get("uf")), "%" + uf + "%");
	}
}
