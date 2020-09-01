package com.apirest.chamados.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.sun.istack.NotNull;

@Entity
@Table(name="subtipoChamado")
public class SubTipoChamado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message =  "Descrição não pode ser vazia")
	@Column(name = "descricao", length = 50, nullable = false, unique = true)
	//@NotNull
	private String descricao;
	
	@Column(name = "ativo", nullable = false)
	private boolean ativo;
	
	@CreatedDate
	@Column(name = "criado", nullable = false, updatable = false)
	private Date criado;
	
	@LastModifiedDate
	@Column(name = "modificado", nullable = false)
	private Date modificado;
	
	@ManyToOne()
	@JoinColumn(name = "idTipoChamado")
	private TipoChamado idTipoChamado;

}
