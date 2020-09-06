package com.apirest.chamados.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.Tecnico;
import com.apirest.chamados.repository.TecnicoRepository;
import com.apirest.chamados.specification.TecnicoSpecification;

import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public List<Tecnico> findAll(Long id, String nomeCompleto, String email, Boolean ativo) throws Exception {
		List<Tecnico> tecnico = new ArrayList<>();
		tecnico = repository.findAll(
				where(
						TecnicoSpecification.nomeCompletoTecnico(nomeCompleto)
						.and(TecnicoSpecification.idTecnico(id))
						.and(TecnicoSpecification.emailTecnico(email))
						.and(TecnicoSpecification.ativoTecnico(ativo))
					)
				);
		if (tecnico.size() == 0) {
			throw new Exception("Não há dados");
		}
		return tecnico;
//		return this.repository.findAll();
	}

	public Optional<Tecnico> findById(Long id) throws Exception {
		var tecnico = repository.findById(id);
		if (!tecnico.isPresent()) {
			throw new Exception("Técnico com o id " + id + " não encontrado");
		}
		return tecnico;
	}

	public Tecnico createTecnico(Tecnico tecnico) throws Exception {
		var nova = this.repository.findByEmail(tecnico.getEmail());
		if (nova.isPresent()) {
			throw new Exception("Técnico com o e-mail " + tecnico.getEmail() + " já cadastrado");
		}
		return this.repository.save(tecnico);
	}

	public Tecnico alterTecnico(Tecnico tecnico) throws Exception {
		var nova = this.repository.findByEmail(tecnico.getEmail());
		if (!nova.isPresent()) {
			throw new Exception(
					"Técnico com o e-mail + " + tecnico.getEmail() + " não encontrado(a), impossíve atualizar");
		}
		return this.repository.save(tecnico);
	}

	public void deleteTecnico(Long id) throws Exception {
		var nova = this.repository.findById(id);
		if (!nova.isPresent()) {
			throw new Exception("Técnico com o id " + id + " não encontrado(a), impossível excluir");
		}
		this.repository.deleteById(id);
	}
}
