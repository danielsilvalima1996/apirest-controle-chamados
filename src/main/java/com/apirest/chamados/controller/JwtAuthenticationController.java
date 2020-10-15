package com.apirest.chamados.controller;

import java.util.List;

import com.apirest.chamados.config.JwtTokenUtil;
import com.apirest.chamados.model.JwtRequest;
import com.apirest.chamados.model.JwtResponse;
import com.apirest.chamados.model.MenuPOUI;
import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.repository.UsuarioRepository;
import com.apirest.chamados.service.JwtUserDetailsService;
import com.apirest.chamados.service.MenuPOUIService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/login")
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private UsuarioRepository repository;


	@Autowired
	private MenuPOUIService menuService;

	@ApiOperation(value = "Endpoint login")
	@PostMapping()
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		Usuario user = repository.findByEmail(authenticationRequest.getUsername());
		authentication(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		List<MenuPOUI> menu = this.menuService.criaMenu(user.getIdRegra().getId());
		JwtResponse response = new JwtResponse();
		
		response.setToken(token);
		response.setEmail(authenticationRequest.getUsername());
		response.setNomeCompleto(user.getNomeCompleto());
		response.setAvatar(user.getAvatar());
		response.setId(user.getId());
		response.setAtivo(user.isAtivo());
		response.setRegra(user.getIdRegra());
		response.setMenu(menu);

		return ResponseEntity.ok(response);
	}

	private void authentication(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("Usuário Inativo", e);
		} catch (BadCredentialsException e) {
			throw new Exception("Login ou Senha Inválidos", e);
		}
	}
}
