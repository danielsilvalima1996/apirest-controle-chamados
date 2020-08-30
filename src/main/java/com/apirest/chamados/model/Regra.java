package com.apirest.chamados.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;

@Entity
@Table(name = "regra")
public class Regra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "descricao", length = 100, nullable = false, unique = true)
	@NotNull
	private String descricao;
	
	@Column(name = "ativo", nullable = false)
	private boolean ativo;
	
	@CreatedDate
	@Column(name = "criado", nullable = false, updatable = false)
	private Date criado;
	
	@LastModifiedDate
	@Column(name = "modificado", nullable = false)
	private Date modificado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getCriado() {
		return criado;
	}

	public void setCriado(Date criado) {
		this.criado = criado;
	}

	public Date getModificado() {
		return modificado;
	}

	public void setModificado(Date modificado) {
		this.modificado = modificado;
	}
	
	/*
	@CreatedDate
	@Column(name = "criadoPor", nullable = false, updatable = false)
	private long criadoPor;
	
	@LastModifiedDate
	@Column(name = "modificadoPor", nullable = false)
	private long modificadoPor;*/
	
	

}