package com.apirest.chamados.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cep", length = 8, nullable = false)
	@NotNull
	private String cep;

	@Column(name = "logradouro", length = 100, nullable = false)
	@NotNull
	private String logradouro;

	@Column(name = "complemento", length = 100, nullable = true)
	@NotNull
	private String complemento;

	@Column(name = "bairro", length = 100, nullable = false)
	@NotNull
	private String bairro;

	@Column(name = "localidade", length = 50, nullable = false)
	@NotNull
	private String localidade;

	@Column(name = "uf", length = 2, nullable = false)
	@NotNull
	private String uf;

	@Column(name = "numero", nullable = false)
	@NotNull
	private Long numero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

}
