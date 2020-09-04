package com.apirest.chamados.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sun.istack.NotNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Email
	@Column(name = "email", unique = true, length = 255, nullable = false)
	private String email;

	@NotNull
	@Column(name = "senha")
	private String senha;

	@NotNull
	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "avatar")
	private String avatar;

	@NotNull
	@Column(name = "ativo", nullable = false)
	private boolean ativo;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "id_regra")
	private Regra idRegra;

	@NotNull
	@ManyToOne()
	@JoinColumn(name = "id_empresa")
	private Empresa idEmpresa;
	
    @OneToOne(mappedBy = "idUsuario")
    private Tecnico idTecnico;
	
	@CreatedDate
	@Column(name = "criado", updatable = false)
	private Date criado;

	@LastModifiedDate
	@Column(name = "modificado")
	private Date modificado;

	@CreatedBy
	@Column(name = "criado_por", updatable = false)
	private String criadoPor;

	@LastModifiedBy
	@Column(name = "modificado_por")
	private String modificadoPor;

	@Column(name = "celular", length = 9)
	private String celular;

	@Column(name = "telefone", length = 8)
	private String telefone;

	@Column(name = "ddd_celular", length = 2)
	private String dddCelular;

	@Column(name = "ddd_telefone", length = 2)
	private String dddTelefone;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Regra getIdRegra() {
		return idRegra;
	}

	public void setIdRegra(Regra idRegra) {
		this.idRegra = idRegra;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	public String getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDddCelular() {
		return dddCelular;
	}

	public void setDddCelular(String dddCelular) {
		this.dddCelular = dddCelular;
	}

	public String getDddTelefone() {
		return dddTelefone;
	}

	public void setDddTelefone(String dddTelefone) {
		this.dddTelefone = dddTelefone;
	}

}
