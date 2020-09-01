package com.apirest.chamados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.SubTipoChamado;
import com.apirest.chamados.repository.SubTipoChamadoRepository;


@Service
public class SubTipoChamadoService {
	
	@Autowired
	private SubTipoChamadoRepository repository;
	
	public SubTipoChamado createSubTipoChamado(SubTipoChamado subTipoChamado) {
		return this.repository.save(subTipoChamado);
	}

}
