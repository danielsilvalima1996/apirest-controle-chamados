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

import com.apirest.chamados.model.SubTipoChamado;
import com.apirest.chamados.service.SubTipoChamadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/subtipoChamado")
public class SubTipoChamadoController {

	@Autowired
	private SubTipoChamadoService subtipoChamadoService;
	
	@ApiOperation(value = "Lista de SubTipoChamado com filtros Id, Descrição e Ativo")
	@GetMapping(produces = { "application/json" })
	public List<SubTipoChamado> findAll(
			@Param(value = "id") Long id,
			@Param(value = "descricao") String descricao,
			@Param(value = "ativo") Boolean ativo,
			@Param(value = "idTipoChamado") Long idTipoChamado
			) throws Exception {
		return this.subtipoChamadoService.findAll(id, descricao, ativo, idTipoChamado);
	}
	
	@ApiOperation(value = "Cria um SubtipoChamado")
	@PostMapping(produces = {"application/json"},consumes ={"application/json"})
	public SubTipoChamado createSubTipoChamado(@Valid @RequestBody SubTipoChamado subtipoChamado) {
		return this.subtipoChamadoService.createSubTipoChamado(subtipoChamado);
	}
	
	@ApiOperation(value = "Encontra um SubTipoChamado por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<SubTipoChamado> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.subtipoChamadoService.findById(id);
	}
	
	@ApiOperation(value = "Altera um SubTipoChamado")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public SubTipoChamado alterSubTipoChamado(@RequestBody @Valid SubTipoChamado subtipoChamado) throws Exception {
		return this.subtipoChamadoService.alterSubTipoChamado(subtipoChamado);
	}
	
	@ApiOperation(value = "Deleta um Tipo Chamado")
	@DeleteMapping(value = "{id}")
	public void deletarSubTipoChamado(@PathVariable("id") Long id) throws Exception {
		this.subtipoChamadoService.deleteSubTipoChamado(id);
	}
}
