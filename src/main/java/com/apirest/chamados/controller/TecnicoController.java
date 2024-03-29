package com.apirest.chamados.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.apirest.chamados.model.Tecnico;
import com.apirest.chamados.service.TecnicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Regra")
@RequestMapping("/api/tecnico")
public class TecnicoController {

	@Autowired
	private TecnicoService service;

	@ApiOperation(value = "Lista de Técnico com filtros Id, Ativo e Id Usuário")
	@GetMapping(produces = { "application/json" })
	public List<Tecnico> findAll(
			@Param(value = "id") Long id,
			@Param(value = "ativo") Boolean ativo,
			@Param(value = "idUsuario") Long idUsuario
			)throws Exception {
		return this.service.findAll(id, ativo, idUsuario);
	}
	
	@ApiOperation(value = "Encontra Técnico por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<Tecnico> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.service.findById(id);
	}

	@ApiOperation(value = "Cria um Técnico")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Tecnico createTecnico(@RequestBody @Valid Tecnico tecnico) throws Exception {
		return this.service.createTecnico(tecnico);
	}
	
	@ApiOperation(value = "Altera um Técnico")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Tecnico alterTecnico(@RequestBody @Valid Tecnico tecnico) throws Exception {
		return this.service.alterTecnico(tecnico);
	}

}
