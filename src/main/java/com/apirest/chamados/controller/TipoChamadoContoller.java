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

import com.apirest.chamados.model.TipoChamado;
import com.apirest.chamados.service.TipoChamadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tipoChamado")
public class TipoChamadoContoller {
	
	@Autowired
	private TipoChamadoService tipoChamadoService;
	
	@ApiOperation(value = "Lista de Tipos Chamado com filtros Id, Descrição e Ativo")
	@GetMapping(produces = { "application/json" })
	public List<TipoChamado> findAll(
			@Param(value = "id") Long id,
			@Param(value = "descricao") String descricao,
			@Param(value = "ativo") Boolean ativo) throws Exception {
		return this.tipoChamadoService.findAll(id, descricao, ativo);
	}
	
	@ApiOperation(value = "Cria um Tipo de Chamado")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<TipoChamado> createTipoChamado(@Valid @RequestBody TipoChamado tipoChamado) {
		return new ResponseEntity<TipoChamado>(
				this.tipoChamadoService.createTipoChamado(tipoChamado), HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Encontra Tipo Chamado por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<TipoChamado> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.tipoChamadoService.findById(id);
	}
	
	@ApiOperation(value = "Altera um Tipo Chamado")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public TipoChamado alterSubTipoChamado(@RequestBody @Valid TipoChamado tipoChamado) throws Exception {
		return this.tipoChamadoService.alterTipoChamado(tipoChamado);
	}
	
	@ApiOperation(value = "Deleta um Tipo Chamado")
	@DeleteMapping(value = "{id}")
	public void deletarTipoChamado(@PathVariable("id") Long id) throws Exception {
		this.tipoChamadoService.deleteTipoChamado(id);
	}

}
