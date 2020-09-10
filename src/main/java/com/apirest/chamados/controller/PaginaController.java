package com.apirest.chamados.controller;

import java.util.List;

import com.apirest.chamados.model.Pagina;
import com.apirest.chamados.repository.PaginaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Página")
@RequestMapping("/api/pagina")
public class PaginaController {

	@Autowired
	private PaginaRepository repository;

	@ApiOperation(value = "Lista de Página")
	@GetMapping(produces = { "application/json" })
	public List<Pagina> findAll() throws Exception {
		return this.repository.findAll();
	}

}
