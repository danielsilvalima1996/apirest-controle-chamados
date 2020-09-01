package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.StatusChamado;
import com.apirest.chamados.repository.StatusChamadoRepository;
import com.apirest.chamados.specification.StatusChamadoSpecification;

@Service
public class StatusChamadoService {
	
	@Autowired
	private StatusChamadoRepository repository;
	
	public List<StatusChamado> findAll(Long id,String cor, String descricao, Boolean ativo) throws Exception {
		List<StatusChamado> statusChamado = new ArrayList<>();
		statusChamado = repository.findAll(where(StatusChamadoSpecification.idStatusChamado(id)).and(StatusChamadoSpecification.corStatusChamado(cor))
				.and(StatusChamadoSpecification.descricaoStatusChamado(descricao)).and(StatusChamadoSpecification.ativoStatusChamado(ativo)));
		if (statusChamado.size() == 0) {
			throw new Exception("Não há dados");
		}
		return statusChamado;
	}
	
	public Optional<StatusChamado> findById(Long id) throws Exception {
		var statusChamado = repository.findById(id);
		if (!statusChamado.isPresent()) {
			throw new Exception("Status Chamado com o id " + id + " não encontrado");
		}
		return statusChamado;
	}
	
	public StatusChamado createStatusChamado(StatusChamado statusChamado) {
		return this.repository.save(statusChamado);
	}
	
	public StatusChamado alterStatusChamado(StatusChamado statusChamado) throws Exception {
		var novo = this.repository.findById(statusChamado.getId());
		if (!novo.isPresent()) {
			throw new Exception("Status Chamado com o id + " + statusChamado.getId() + " não encontrado");
		}
		return this.repository.save(statusChamado);
	}
	
	public void deleteStatusChamado(Long id) throws Exception {
		var novo = this.repository.findById(id);
		if(!novo.isPresent()) {
			throw new Exception("Status Chamado com id " + id + "não encontrada, impossível excluir");
		}
		this.repository.deleteById(id);
	}

}
