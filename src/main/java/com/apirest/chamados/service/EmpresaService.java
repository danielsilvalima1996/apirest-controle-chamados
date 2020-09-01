package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.Empresa;
import com.apirest.chamados.repository.EmpresaRepository;
import com.apirest.chamados.specification.EmpresaSpecification;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public List<Empresa> findAll(
			Long id, 
			String cnpj, 
			String razaoSocial, 
			String nomeFantasia, 
			Boolean ativo,
			String cep, 
			String logradouro, 
			String bairro, 
			String localidade, 
			String uf) throws Exception {
		List<Empresa> empresa = new ArrayList<>();
		empresa = repository.findAll(
				where(
						EmpresaSpecification.idEmpresa(id))
						.and(EmpresaSpecification.cnpjEmpresa(cnpj))
						.and(EmpresaSpecification.razaoSocialEmpresa(razaoSocial))
						.and(EmpresaSpecification.nomeFantasiaEmpresa(nomeFantasia))
						.and(EmpresaSpecification.ativoEmpresa(ativo))
						.and(EmpresaSpecification.cepEmpresa(cep))
						.and(EmpresaSpecification.logradouroEmpresa(logradouro))
						.and(EmpresaSpecification.bairroEmpresa(bairro))
						.and(EmpresaSpecification.localidadeEmpresa(localidade))
						.and(EmpresaSpecification.ufEmpresa(uf))
				);
		if (empresa.size() == 0) {
			throw new Exception("Não há dados");
		}
		return empresa;
	}

	public Optional<Empresa> findById(Long id) throws Exception {
		var Empresa = repository.findById(id);
		if (!Empresa.isPresent()) {
			throw new Exception("Empresa com o id " + id + " não encontrada");
		}
		return Empresa;
	}

	public Empresa createEmpresa(Empresa empresa) throws Exception {
		var duplicated = this.repository.findByCnpj(empresa.getCnpj());
		if (duplicated != null) {
			throw new Exception("CNPJ " + empresa.getCnpj() + " já cadastrado");
		}
		return this.repository.save(empresa);
	}

	public Empresa alterEmpresa(Empresa empresa) throws Exception {
		var nova = this.repository.findById(empresa.getId());
		if (!nova.isPresent()) {
			throw new Exception("Empresa com o id " + empresa.getId() + " não encontrada, impossíve atualizar");
		}
		return this.repository.save(empresa);
	}

	public void deleteEmpresa(Long id) throws Exception {
		var nova = this.repository.findById(id);
		if (!nova.isPresent()) {
			throw new Exception("Empresa com o id " + id + " não encontrada, impossível excluir");
		}
		this.repository.deleteById(id);
	}
}
