package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.apirest.chamados.config.JwtTokenUtil;
import com.apirest.chamados.model.RetornoStatus;
import com.apirest.chamados.model.TrocarSenha;
import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.repository.UsuarioRepository;
import com.apirest.chamados.specification.UsuarioSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private static final BCryptPasswordEncoder bc = new BCryptPasswordEncoder();

	public List<Usuario> findAll(Long id, String email, String nomeCompleto, Boolean ativo, Long idRegra,
			Long idEmpresa, Boolean isTecnico) throws Exception {
		List<Usuario> usuario = new ArrayList<>();
		usuario = repository
				.findAll(where(UsuarioSpecification.idUsuario(id)).and(UsuarioSpecification.emailUsuario(email))
						.and(UsuarioSpecification.nomeCompletoUsuario(nomeCompleto))
						.and(UsuarioSpecification.ativoUsuario(ativo)).and(UsuarioSpecification.idRegraUsuario(idRegra))
						.and(UsuarioSpecification.idEmpresaUsuario(idEmpresa))
						.and(UsuarioSpecification.isTecnicoUsuario(isTecnico)));
		if (usuario.size() == 0) {
			throw new Exception("Não há dados");
		}
		usuario.forEach(u -> u.setSenha(""));
		return usuario;
	}

	public Optional<Usuario> findById(Long id) throws Exception {
		var usuario = repository.findById(id);
		if (!usuario.isPresent()) {
			throw new Exception("Usuário com o id " + id + " não encontrado");
		}
		usuario.get().setSenha("");
		return usuario;
	}

	public Usuario createUsuario(Usuario usuario) throws Exception {
		var duplicated = this.repository.findByEmail(usuario.getEmail());
		if (duplicated != null) {
			throw new Exception("E-mail " + usuario.getEmail() + " já cadastrado");
		}
		if (usuario.getSenha().isEmpty()) {
			throw new Exception("A senha não pode ser vazia");
		}
		String result = bc.encode(usuario.getSenha());
		usuario.setSenha(result);
		String avatar = "https://api.adorable.io/avatars/64/" + usuario.getEmail() + ".png";
		usuario.setAvatar(avatar);
		usuario.setAtivo(true);
		Usuario novo = this.repository.save(usuario);
		novo.setSenha("");
		return novo;
	}

	public Usuario alterUsuario(Usuario usuario) throws Exception {
		var nova = this.repository.findById(usuario.getId());
		if (!nova.isPresent()) {
			throw new Exception("Usuario com o id + " + usuario.getId() + " não encontrado, impossíve atualizar");
		}
		if (usuario.getSenha() != "") {
			String result = bc.encode(usuario.getSenha());
			usuario.setSenha(result);
		} else {
			usuario.setSenha(nova.get().getSenha().toString());
		}
		String avatar = "https://api.adorable.io/avatars/64/" + usuario.getEmail() + ".png";
		usuario.setAvatar(avatar);
		Usuario novo = this.repository.save(usuario);
		novo.setSenha("");
		return novo;
	}

	public RetornoStatus trocarSenha(TrocarSenha senhas) throws Exception {
		String email;
		String jwtToken;
		final String requestTokenHeader = this.request.getHeader("Authorization");
		jwtToken = requestTokenHeader.substring(7);
		email = jwtTokenUtil.getUsernameFromToken(jwtToken);
		Usuario usuario = this.repository.findByEmail(email);
		RetornoStatus status = new RetornoStatus(false);
		if (usuario != null) {
			if (!usuario.isAtivo()) {
				throw new Exception("Usuário Inativo");
			} else {
				if (!bc.matches(senhas.getSenhaAtual(), usuario.getSenha())){
					throw new Exception("Senha atual não confere");
				} else {
					usuario.setSenha(bc.encode(senhas.getSenhaNova()));
					status.setStatus(true);
					this.repository.save(usuario);
				}
			}
		} else {
			throw new Exception("Usuário não encontrado");
		}
		return status;
	}

	public void deleteUsuario(Long id) throws Exception {
		var nova = this.repository.findById(id);
		if (!nova.isPresent()) {
			throw new Exception("Usuario com o id " + id + " não encontrado, impossível excluir");
		}
		this.repository.deleteById(id);
	}
}
