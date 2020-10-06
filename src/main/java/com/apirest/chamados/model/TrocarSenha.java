package com.apirest.chamados.model;

import java.io.Serializable;

public class TrocarSenha implements Serializable {

	private static final long serialVersionUID = 1L;

	private String senhaAtual;
	private String senhaNova;

	public TrocarSenha() {
	}

	public TrocarSenha(String senhaAtual, String senhaNova) {
		this.senhaAtual = senhaAtual;
		this.senhaNova = senhaNova;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getSenhaNova() {
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova) {
		this.senhaNova = senhaNova;
	}

}
