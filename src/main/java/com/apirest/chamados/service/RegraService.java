package com.apirest.chamados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.Regra;
import com.apirest.chamados.repository.RegraRepository;

@Service
public class RegraService {

	@Autowired
	private RegraRepository repository;
	
	public List<Regra> findAll() {
		return this.repository.findAll();
	}
	
	public Regra createRegra(Regra regra) {
		return this.repository.save(regra);
	}
}
