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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "chamado")
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario idUsuario;
	
	@Column(name = "data_abertura")
	private Date dataAbertura;
	
	@Column(name = "data_fechamento")
	private Date dataFechamento;
	
	@Column(name = "status_chamado")
	private Integer statusChamado;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_chamado")
	private TipoChamado idTipoChamado;
	
	@ManyToOne
	@JoinColumn(name = "id_subtipo_chamado")
	private SubTipoChamado idSubtipoChamado;
	
	@ManyToOne
	@JoinColumn(name = "id_tecnico")
	private Tecnico idTecnico;

	@NotBlank(message =  "Descrição não pode ser vazia")
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;

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

	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "idChamado", fetch = FetchType.EAGER)
	private List<ComentarioChamado> idComentarioChamado = new ArrayList<ComentarioChamado>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getStatusChamado() {
		return statusChamado;
	}

	public void setStatusChamado(Integer statusChamado) {
		this.statusChamado = statusChamado;
	}

	public TipoChamado getIdTipoChamado() {
		return idTipoChamado;
	}

	public void setIdTipoChamado(TipoChamado idTipoChamado) {
		this.idTipoChamado = idTipoChamado;
	}

	public SubTipoChamado getIdSubtipoChamado() {
		return idSubtipoChamado;
	}

	public void setIdSubtipoChamado(SubTipoChamado idSubtipoChamado) {
		this.idSubtipoChamado = idSubtipoChamado;
	}

	public Tecnico getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Tecnico idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	// public List<ComentarioChamado> getIdComentarioChamado() {
	// 	return idComentarioChamado;
	// }

	// public void setIdComentarioChamado(List<ComentarioChamado> idComentarioChamado) {
	// 	this.idComentarioChamado = idComentarioChamado;
	// }

	

}
