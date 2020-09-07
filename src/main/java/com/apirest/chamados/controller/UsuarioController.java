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

import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.service.UsuarioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@Api(value="API REST Usuário")
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@ApiOperation(value = "Lista de Usuário com filtros Id, E-mail, Nome Completo, Ativo, Id Regra, Id Empresa e isTecnico")
	@GetMapping(produces = { "application/json" })
	public List<Usuario> findAll(
			@Param(value = "id") Long id,
			@Param(value = "email") String email,
			@Param(value = "nomeCompleto") String nomeCompleto,
			@Param(value = "ativo") Boolean ativo,
			@Param(value = "idRegra") Long idRegra,
			@Param(value = "idEmpresa") Long idEmpresa,
			@Param(value = "isTecnico") Boolean isTecnico) throws Exception {
		return this.service.findAll(id, email, nomeCompleto, ativo, idRegra, idEmpresa, isTecnico);
	}
	
	@ApiOperation(value = "Encontra Usuario por Id")
	@GetMapping(value = "{id}", produces = { "application/json" })
	public Optional<Usuario> findById(
			@PathVariable(value = "id") Long id) throws Exception {
		return this.service.findById(id);
	}

	@ApiOperation(value = "Cria um Usuário")
	@PostMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Usuario createUsuario(@RequestBody @Valid Usuario usuario) throws Exception {
		return this.service.createUsuario(usuario);
	}
	
	@ApiOperation(value = "Altera um Usuário")
	@PutMapping(produces = { "application/json" }, consumes = { "application/json" })
	public Usuario alterUsuario(@RequestBody @Valid Usuario usuario) throws Exception {
		return this.service.alterUsuario(usuario);
	}
	
	@ApiOperation(value = "Deleta um Usuario")
	@DeleteMapping(value = "{id}")
	public void deleteUsuario(@PathVariable("id") Long id) throws Exception {
		this.service.deleteUsuario(id);
	}

}
