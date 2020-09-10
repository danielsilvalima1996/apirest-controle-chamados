package com.apirest.chamados.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.repository.UsuarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = repository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
		}
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getIdRegra().getDescricao());
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		list.add(authority);
		return new User(user.getEmail(), user.getSenha(), list);
	}
}
