package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.Regra;
import com.apirest.chamados.repository.RegraRepository;
import com.apirest.chamados.specification.RegraSpecification;

@Service
public class RegraService {

	@Autowired
	private RegraRepository repository;

	public List<Regra> findAll(Long id, String descricao, Boolean ativo) throws Exception {
		List<Regra> regra = new ArrayList<>();
		regra = repository.findAll(where(RegraSpecification.idRegra(id))
				.and(RegraSpecification.descricaoRegra(descricao)).and(RegraSpecification.ativoRegra(ativo)));
		if (regra.size() == 0) {
			throw new Exception("Não há dados");
		}
		return regra;
	}

	public Optional<Regra> findById(Long id) throws Exception {
		var regra = repository.findById(id);
		if (!regra.isPresent()) {
			throw new Exception("Regra com o id " + id + " não encontrada");
		}
		return regra;
	}

	public Regra createRegra(Regra regra) {
		return this.repository.save(regra);
	}

	public Regra alterRegra(Regra regra) throws Exception {
		var nova = this.repository.findById(regra.getId());
		if (!nova.isPresent()) {
			throw new Exception("Regra com o id + " + regra.getId() + " não encontrada, impossíve possível");
		}
		return this.repository.save(regra);
	}

	public void deleteRegra(Long id) throws Exception {
		var nova = this.repository.findById(id);
		if (!nova.isPresent()) {
			throw new Exception("Regra com o id " + id + " não entrada, impossível excluir");
		}
		this.repository.deleteById(id);
	}
}
