package com.apirest.chamados.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.apirest.chamados.model.StatusChamado;
import com.apirest.chamados.service.StatusChamadoService;

import io.swagger.annotations.ApiOperation;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/statusChamado")
public class StatusChamadoController {
	
	@Autowired
	private StatusChamadoService stausChamadoService;
	
	@ApiOperation(value = "Lista de Status Chamados com filtros Id,Cor, Descrição e Ativo")
	@GetMapping(produces = { "application/json" })
	public List<StatusChamado> findAll(
			@Param(value = "id") Long id,
			@Param(value = "descricao") String descricao,
			@Param(value = "cor") String cor,
			@Param(value = "ativo") Boolean ativo) throws Exception {
		return this.stausChamadoService.findAll(id, cor, descricao, ativo);
	}
	
	@ApiOperation(value = "Encontra Status Chamado por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<StatusChamado> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.stausChamadoService.findById(id);
	}

	@ApiOperation(value = "Cria uma Status Chamado")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<StatusChamado> createStatusChamado(@Valid @RequestBody StatusChamado statusChamado) {
		return new ResponseEntity<StatusChamado>(
				this.stausChamadoService.createStatusChamado(statusChamado), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Altera um Status Chamado")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public StatusChamado alterStatusChamado(@RequestBody @Valid StatusChamado statusChamado) throws Exception {
		return this.stausChamadoService.alterStatusChamado(statusChamado);
	}
	
	@ApiOperation(value = "Deleta um Status Chamado")
	@DeleteMapping(value = "{id}")
	public void deletarStatusChamado(@PathVariable("id") Long id) throws Exception {
		this.stausChamadoService.deleteStatusChamado(id);
	}
}
