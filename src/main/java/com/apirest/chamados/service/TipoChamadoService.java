package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.TipoChamado;
import com.apirest.chamados.repository.TipoChamadoRepository;
import com.apirest.chamados.specification.TipoChamadoSpecification;

@Service
public class TipoChamadoService {
	
	@Autowired
	private TipoChamadoRepository repository;
	
	public List<TipoChamado> findAll(Long id, String descricao, Boolean ativo) throws Exception {
		List<TipoChamado> tipoChamado = new ArrayList<>();
		tipoChamado = repository.findAll(where(TipoChamadoSpecification.idTipoChamado(id))
				.and(TipoChamadoSpecification.descricaoTipoChamado(descricao)).and(TipoChamadoSpecification.ativoTipoChamado(ativo)));
		if (tipoChamado.size() == 0) {
			throw new Exception("Não há dados");
		}
		return tipoChamado;
	}
	
	public Optional<TipoChamado> findById(Long id) throws Exception {
		var tipoChamado = repository.findById(id);
		if (!tipoChamado.isPresent()) {
			throw new Exception("Tipo Chamado com o id " + id + " não encontrado");
		}
		return tipoChamado;
	}

	public TipoChamado createTipoChamado(TipoChamado tipoChamado) {
		return this.repository.save(tipoChamado);
	}
	
	public TipoChamado alterTipoChamado(TipoChamado tipoChamado) throws Exception {
		var novo = this.repository.findById(tipoChamado.getId());
		if (!novo.isPresent()) {
			throw new Exception("Tipo Chamado com o id + " + tipoChamado.getId() + " não encontrado");
		}
		return this.repository.save(tipoChamado);
	}
	
	public void deleteTipoChamado(Long id) throws Exception {
		var novo = this.repository.findById(id);
		if(!novo.isPresent()) {
			throw new Exception("Tipo Chamado com id " + id + "não encontrado, impossível excluir");
		}
		this.repository.deleteById(id);
	}
}
