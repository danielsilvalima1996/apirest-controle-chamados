package com.apirest.chamados.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.apirest.chamados.config.JwtTokenUtil;
import com.apirest.chamados.model.JwtRequest;
import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.repository.UsuarioRepository;
import com.apirest.chamados.service.JwtUserDetailsService;

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

	@ApiOperation(value = "Endpoint login")
	@PostMapping()
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		Usuario user = repository.findByEmail(authenticationRequest.getUsername());
		authentication(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);

		Map<Object, Object> model = new HashMap<>();
		model.put("token", token);
		model.put("email", authenticationRequest.getUsername());
		model.put("nomeCompleto", "Verificar property nomeCompleto");
		model.put("avatar", user.getAvatar());
		model.put("id", user.getId());
		model.put("ativo", user.isAtivo());

		return ResponseEntity.ok(model);
	}

	private void authentication(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
