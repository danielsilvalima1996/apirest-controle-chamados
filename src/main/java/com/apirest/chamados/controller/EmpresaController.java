package com.apirest.chamados.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.chamados.model.Empresa;
import com.apirest.chamados.service.EmpresaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Empresa")
@RequestMapping("/api/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@ApiOperation(value = "Lista de Empresas com filtros")
	@GetMapping(produces = { "application/json" })
	public List<Empresa> findAll(
			@Param(value = "id") Long id,
			@Param(value = "cnpj") String cnpj,
			@Param(value = "razaoSocial") String razaoSocial,
			@Param(value = "nomeFantasia") String nomeFantasia,
			@Param(value = "ativo") Boolean ativo,
			@Param(value = "cep") String cep,
			@Param(value = "logradouro") String logradouro,
			@Param(value = "bairro") String bairro,
			@Param(value = "localidade") String localidade,
			@Param(value = "uf") String uf) throws Exception {
		return this.service.findAll(id, cnpj, razaoSocial, nomeFantasia, ativo, cep, logradouro, bairro, localidade, uf);
	}
	
	@ApiOperation(value = "Encontra Empresa por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<Empresa> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.service.findById(id);
	}

	@ApiOperation(value = "Cria uma Empresa")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Empresa createEmpresa(@RequestBody @Valid Empresa Empresa) throws Exception {
		return this.service.createEmpresa(Empresa);
	}
	
	@ApiOperation(value = "Altera uma Empresa")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Empresa alterEmpresa(@RequestBody @Valid Empresa Empresa) throws Exception {
		return this.service.alterEmpresa(Empresa);
	}
	
	@ApiOperation(value = "Deleta uma Empresa")
	@DeleteMapping(value = "{id}")
	public void alterEmpresa(@PathVariable("id") Long id) throws Exception {
		this.service.deleteEmpresa(id);
	}

}
