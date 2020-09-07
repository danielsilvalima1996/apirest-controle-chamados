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

import com.apirest.chamados.model.Regra;
import com.apirest.chamados.service.RegraService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Regra")
@RequestMapping("/api/regra")
public class RegraController {

	@Autowired
	private RegraService service;

	@ApiOperation(value = "Lista de Regras com filtros Id, Descrição e Ativo")
	@GetMapping(produces = { "application/json" })
	public List<Regra> findAll(
			@Param(value = "id") Long id,
			@Param(value = "descricao") String descricao, 
			@Param(value = "ativo") Boolean ativo) throws Exception {
		return this.service.findAll(id, descricao, ativo);
	}
	
	@ApiOperation(value = "Encontra Regra por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<Regra> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.service.findById(id);
	}

	@ApiOperation(value = "Cria uma Regra")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Regra createRegra(@RequestBody @Valid Regra regra) throws Exception {
		return this.service.createRegra(regra);
	}
	
	@ApiOperation(value = "Altera uma Regra")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Regra alterRegra(@RequestBody @Valid Regra regra) throws Exception {
		return this.service.alterRegra(regra);
	}
	
	@ApiOperation(value = "Deleta uma Regra")
	@DeleteMapping(value = "{id}")
	public void deleteRegra(@PathVariable("id") Long id) throws Exception {
		this.service.deleteRegra(id);
	}

}
