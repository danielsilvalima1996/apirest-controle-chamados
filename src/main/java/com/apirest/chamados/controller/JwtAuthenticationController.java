package com.apirest.chamados.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.apirest.chamados.config.JwtTokenUtil;
import com.apirest.chamados.model.JwtRequest;
import com.apirest.chamados.model.MenuPOUI;
import com.apirest.chamados.model.Pagina;
import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.repository.UsuarioRepository;
import com.apirest.chamados.service.JwtUserDetailsService;

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
		model.put("nomeCompleto", user.getNomeCompleto());
		model.put("avatar", user.getAvatar());
		model.put("id", user.getId());
		model.put("ativo", user.isAtivo());
		List<Pagina> paginas = user.getIdRegra().getIdPagina();
		paginas.stream().sorted((a, b) -> a.getParent().compareTo(b.getParent()));
		List<MenuPOUI> menu = new ArrayList<>();
		for (Pagina p : paginas) {
			if (p.getParent() == 0) {
				menu.add(new MenuPOUI(p.getId(), p.getIcon(), p.getLabel(), p.getShortLabel(), p.getLink(),
						new ArrayList<>()));
			} else {
				MenuPOUI pai = menu.stream().filter(item -> item.getId() == p.getParent()).findFirst().get();
				List<MenuPOUI> aux = pai.getSubItems();
				aux.add(new MenuPOUI(p.getId(), p.getIcon(), p.getLabel(), p.getShortLabel(),
						pai.getLink() + p.getLink(), new ArrayList<>()));
				aux = aux.stream().sorted((a, b) -> a.getLabel().compareTo(b.getLabel())).collect(Collectors.toList());
				pai.setSubItems(aux);
			}
		}
		model.put("menu", menu);
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
