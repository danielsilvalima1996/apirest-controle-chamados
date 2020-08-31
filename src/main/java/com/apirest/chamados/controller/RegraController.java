package com.apirest.chamados.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.chamados.model.Regra;
import com.apirest.chamados.service.RegraService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/regra")
public class RegraController {

	@Autowired
	private RegraService service;

	@ApiOperation(value = "Lista de Regras com filtros Id, Descrição e Ativo")
	@GetMapping(produces = { "application/json" })
	public ResponseEntity<List<Regra>> findAll(
			@Param(value = "id") Long id,
			@Param(value = "descricao") String descricao, 
			@Param(value = "ativo") Boolean ativo) {
		return new ResponseEntity<List<Regra>>(
				this.service.findAll(id, descricao, ativo), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Encontra Regra por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public ResponseEntity<Optional<Regra>> findById(
			@PathVariable(value = "id") Long id) {
		return new ResponseEntity<Optional<Regra>>(
				this.service.findById(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Cria uma Regra")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Regra> createRegra(@Valid @RequestBody Regra regra) {
		return new ResponseEntity<Regra>(
				this.service.createRegra(regra), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Altera uma Regra")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<Regra> alterRegra(@Valid @RequestBody Regra regra) {
		return new ResponseEntity<Regra>(
				this.service.alterRegra(regra), HttpStatus.OK);
	}

}
