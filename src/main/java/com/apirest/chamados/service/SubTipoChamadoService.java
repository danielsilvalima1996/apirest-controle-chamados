package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.SubTipoChamado;
import com.apirest.chamados.repository.SubTipoChamadoRepository;
import com.apirest.chamados.specification.SubTipoChamadoSpecification;


@Service
public class SubTipoChamadoService {
	
	@Autowired
	private SubTipoChamadoRepository repository;
	
	
	public List<SubTipoChamado> findAll(Long id, String descricao, Boolean ativo, Long idTipoChamado) throws Exception {
		List<SubTipoChamado> subtipoChamado = new ArrayList<>();
		subtipoChamado = repository.findAll(
			where(
				SubTipoChamadoSpecification.idSubTipoChamado(id))
				.and(SubTipoChamadoSpecification.descricaoSubTipoChamado(descricao))
				.and(SubTipoChamadoSpecification.ativoSubTipoChamado(ativo))
				.and(SubTipoChamadoSpecification.idTipoChamadoSubtipoChamado(idTipoChamado)));
		if (subtipoChamado.size() == 0) {
			throw new Exception("Não há dados");
		}
		return subtipoChamado;
	}
	
	public SubTipoChamado createSubTipoChamado(SubTipoChamado subTipoChamado) {
		return this.repository.save(subTipoChamado);
	}
	
	public Optional<SubTipoChamado> findById(Long id) throws Exception {
		var subtipoChamado = repository.findById(id);
		if (!subtipoChamado.isPresent()) {
			throw new Exception("SubTipo Chamado com o id " + id + " não encontrado");
		}
		return subtipoChamado;
	}
	
	public SubTipoChamado alterSubTipoChamado(SubTipoChamado subtipoChamado) throws Exception {
		var novo = this.repository.findById(subtipoChamado.getId());
		if (!novo.isPresent()) {
			throw new Exception("SubTipoChamado com o id + " + subtipoChamado.getId() + " não encontrado");
		}
		return this.repository.save(subtipoChamado);
	}
	
	public void deleteSubTipoChamado(Long id) throws Exception {
		var novo = this.repository.findById(id);
		if(!novo.isPresent()) {
			throw new Exception("SubTipoChamado com id " + id + "não encontrado, impossível excluir");
		}
		this.repository.deleteById(id);
	}

}
