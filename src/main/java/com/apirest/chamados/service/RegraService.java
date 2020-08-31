package com.apirest.chamados.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.Regra;
import com.apirest.chamados.repository.RegraRepository;
import com.apirest.chamados.specification.RegraSpecification;
import static org.springframework.data.jpa.domain.Specification.where;


@Service
public class RegraService {

	@Autowired
	private RegraRepository repository;
	
	public List<Regra> findAll(Long id, String descricao, Boolean ativo) {
		List<Regra> regra = new ArrayList<>();
		regra = repository.findAll(
				where(RegraSpecification.idRegra(id))
				.and(RegraSpecification.descricaoRegra(descricao))
				.and(RegraSpecification.ativoRegra(ativo)));
		return regra;
	}
	
	public Optional<Regra> findById(Long id) {
		return this.repository.findById(id);
	}
	
	public Regra createRegra(Regra regra) {
		return this.repository.save(regra);
	}
	
	public Regra alterRegra(Regra regra) {
		return this.repository.save(regra);
	}
}
