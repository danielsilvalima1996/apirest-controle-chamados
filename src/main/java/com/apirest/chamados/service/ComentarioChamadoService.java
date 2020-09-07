package com.apirest.chamados.service;

import com.apirest.chamados.model.ComentarioChamado;
import com.apirest.chamados.repository.ComentarioChamadoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioChamadoService {

    @Autowired
	private ComentarioChamadoRepository repository;

    public ComentarioChamado createComentarioChamado(ComentarioChamado comentarioChamado) {
		return this.repository.save(comentarioChamado);
	}

}
