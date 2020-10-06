package com.apirest.chamados.model;

import java.io.Serializable;

public class RetornoStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean status;

	public RetornoStatus() {
	}

	public RetornoStatus(boolean status) {
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
