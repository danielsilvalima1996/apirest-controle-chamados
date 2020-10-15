package com.apirest.chamados.model;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String token;
	private Long id;
	private String email;
	private String nomeCompleto;
	private String avatar;
	private Boolean ativo;
	private Regra regra;
	private List<MenuPOUI> menu;

	public JwtResponse() {

	}

	public JwtResponse(String token, Long id, String email, String nomeCompleto, String avatar, Boolean ativo,
			Regra regra, List<MenuPOUI> menu) {
		this.token = token;
		this.id = id;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.avatar = avatar;
		this.ativo = ativo;
		this.regra = regra;
		this.menu = menu;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}

	public List<MenuPOUI> getMenu() {
		return menu;
	}

	public void setMenu(List<MenuPOUI> menu) {
		this.menu = menu;
	}

}
