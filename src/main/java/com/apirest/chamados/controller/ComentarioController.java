package com.apirest.chamados.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.chamados.model.ComentarioChamado;
import com.apirest.chamados.service.ComentarioChamadoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST COMENTÁRIO CHAMADO")
@RequestMapping("/api/comentarioChamado")
public class ComentarioController {

	@Autowired
	private ComentarioChamadoService service;
	
	@ApiOperation(value = "Cria um Comentário Chamado")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public ComentarioChamado createComentarioChamado(@RequestBody @Valid ComentarioChamado comentarioChamado) throws Exception {
		return this.service.createComentarioChamado(comentarioChamado);
	}
}
