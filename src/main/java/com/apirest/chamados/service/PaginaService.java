package com.apirest.chamados.service;

import java.util.List;
import java.util.Optional;

import com.apirest.chamados.model.Pagina;
import com.apirest.chamados.repository.PaginaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaginaService {

	@Autowired
	private PaginaRepository repository;

	public List<Pagina> findAll() throws Exception {
		return this.repository.findAll();
	}

	public Optional<Pagina> findById(Long id) {
		return this.repository.findById(id);
	}

}
