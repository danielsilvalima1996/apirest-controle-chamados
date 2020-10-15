package com.apirest.chamados.controller;

import java.util.List;

import com.apirest.chamados.model.MenuPOUI;
import com.apirest.chamados.service.MenuPOUIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Menu PO UI")
@RequestMapping("/api/menupoui")
public class MenuPOUIController {

	@Autowired
	private MenuPOUIService service;

	@ApiOperation(value = "Retorna o Menu PO UI")
	@GetMapping(value = "{idRegra}", produces = { "application/json" })
	public List<MenuPOUI> retornarMenu(@PathVariable("idRegra") Long idRegra) throws Exception {
		return this.service.criaMenu(idRegra);
	}

}
