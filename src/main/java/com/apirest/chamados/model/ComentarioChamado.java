package com.apirest.chamados.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "comentario_chamado")
public class ComentarioChamado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@NotBlank(message =  "Comentário não pode ser vazio")
	@Column(name = "comentario", length = 255, nullable = false)
	
	private String comentario;

	@JoinColumn(name = "id_chamado")
	@ManyToOne()
	private Chamado idChamado;
	
	
	@JoinColumn(name = "id_usuario")
	@ManyToOne()
	private Chamado idUsuario;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Chamado getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Chamado idUsuario) {
		this.idUsuario = idUsuario;
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

	public Chamado getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(Chamado idChamado) {
		this.idChamado = idChamado;
	}

	
	

}
