package com.apirest.chamados.model;

public class Home {

	private String label;
	private Integer status ;
	private String color;
	private Long quantidade;

	public Home() {
	}

	public Home(String label, Integer status, String color, Long quantidade) {
		this.label = label;
		this.status = status;
		this.color = color;
		this.quantidade = quantidade;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
}
