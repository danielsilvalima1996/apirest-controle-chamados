package com.apirest.chamados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@ApiOperation(value = "Lista de Regras")
	@GetMapping(produces = { "application/json" })
	public List<Regra> findAll() {
		return this.service.findAll();
	}

	@ApiOperation(value = "Cria uma Regra")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Regra createRegra(@RequestBody Regra regra) {
		return this.service.createRegra(regra);
	}

}
