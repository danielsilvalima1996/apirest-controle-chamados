package com.apirest.chamados.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.apirest.chamados.model.Chamado;
import com.apirest.chamados.model.Home;
import com.apirest.chamados.service.ChamadoService;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Chamado")
@RequestMapping("/api/chamado")
public class ChamadoController {

	@Autowired
	private ChamadoService service;

	@ApiOperation(value = "Lista de Chamado com filtros Id, Descrição e Ativo")
	@GetMapping(produces = { "application/json" })
	public List<Chamado> findAll(
		@Param(value = "id") Long id, 
		@Param(value = "idUsuario") Long idUsuario, 
		@Param(value = "statusChamado") Integer statusChamado, 
		@Param(value = "idTipoChamado") Long idTipoChamado, 
		@Param(value = "idSubtipoChamado") Long idSubtipoChamado, 
		@Param(value = "idTecnico") Long idTecnico, 
		@Param(value = "descricao") String descricao) throws Exception {
		return this.service.findAll(id, idUsuario, statusChamado, idTipoChamado, idSubtipoChamado, idTecnico, descricao);
	}
	
	@ApiOperation(value = "Encontra Chamado por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<Chamado> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.service.findById(id);
	}

	@ApiOperation(value = "Cria um Chamado")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Chamado createChamado(@RequestBody @Valid Chamado chamado) throws Exception {
		return this.service.createChamado(chamado);
	}
	
	@ApiOperation(value = "Altera um Chamado")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Chamado alterChamado(@RequestBody @Valid Chamado chamado) throws Exception {
		return this.service.alterChamado(chamado);
	}

	@ApiOperation(value = "Finaliza um Chamado")
	@PutMapping(value = "finaliza", produces = { "application/json" }, consumes = { "application/json" })
	public Chamado finalizaChamado(@RequestBody @Valid Chamado chamado) throws Exception {
		return this.service.finalizaChamado(chamado);
	}

	@ApiOperation(value = "Indefere um Chamado")
	@PutMapping(value = "indefere", produces = { "application/json" }, consumes = { "application/json" })
	public Chamado indefiridoChamado(@RequestBody @Valid Chamado chamado) throws Exception {
		return this.service.indefiridoChamado(chamado);
	}
	
	@ApiOperation(value = "Deleta um Chamado")
	@DeleteMapping(value = "{id}")
	public void alterChamado(@PathVariable("id") Long id) throws Exception {
		this.service.deleteChamado(id);
	}

	@ApiOperation(value = "Dados da home")
	@GetMapping(value = "home", produces = { "application/json" })
	public List<Home> findHome() throws Exception {
		return this.service.findHome();
	}

}
