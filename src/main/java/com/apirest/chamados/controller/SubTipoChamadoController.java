package com.apirest.chamados.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@ApiOperation(value = "Cria um subtipo Chamado")
	@PostMapping(produces = {"application/json"},consumes ={"application/json"})
	public SubTipoChamado createSubTipoChamado(@Valid @RequestBody SubTipoChamado subtipoChamado) {
		return this.subtipoChamadoService.createSubTipoChamado(subtipoChamado);
	}
}
