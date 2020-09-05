package com.apirest.chamados.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.chamados.model.ViaCep;
import com.apirest.chamados.service.ViaCepService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST VIACEP")
@RequestMapping("/api/viacep")
public class ViaCepController {

	@ApiOperation(value = "Busca de CEP pelo via CEP")
	@GetMapping(value = "{cep}", produces = { "application/json" })
	public static ViaCep buscaPorCep(@PathVariable(value = "cep") String cep) throws Exception {
		return ViaCepService.buscaEnderecoPelo(cep);
	}

}
