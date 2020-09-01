package com.apirest.chamados.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.sun.istack.NotNull;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cnpj", length = 14, nullable = false, unique = true)
	@Pattern(regexp = "([0-9]{14})", message = "CNPJ deve conter somente números com 14 digitos")
	@NotNull
	private String cnpj;

	@Column(name = "razao_social", length = 100, nullable = false)
	@NotNull
	private String razaoSocial;

	@Column(name = "nome_fantasia", length = 100, nullable = false)
	@NotNull
	private String nomeFantasia;

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

	@Column(name = "ativo", nullable = false)
	@NotNull
	private boolean ativo;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "idEmpresa", fetch = FetchType.EAGER)
	private List<Usuario> idUsuario = new ArrayList<Usuario>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

	public List<Usuario> getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(List<Usuario> idUsuario) {
		this.idUsuario = idUsuario;
	}

}
