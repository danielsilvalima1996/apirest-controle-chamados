package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apirest.chamados.model.Tecnico;
import com.apirest.chamados.model.Usuario;
import com.apirest.chamados.repository.TecnicoRepository;
import com.apirest.chamados.specification.TecnicoSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;

	public List<Tecnico> findAll(Long id, Boolean ativo, Long idUsuario) throws Exception {
		List<Tecnico> tecnico = new ArrayList<>();
		tecnico = this.repository.findAll(where(TecnicoSpecification.idTecnico(id))
				.and(TecnicoSpecification.idUsuario(idUsuario))
				.and(TecnicoSpecification.ativoTecnico(ativo)));

		if (tecnico.size() == 0) {
			return new ArrayList<>();
		}
		tecnico.forEach(item -> item.getIdUsuario().setSenha(""));
		return tecnico;
	}

	public Optional<Tecnico> findById(Long id) throws Exception {
		var tecnico = repository.findById(id);
		if (!tecnico.isPresent()) {
			throw new Exception("Técnico com o id " + id + " não encontrado");
		}
		return tecnico;
	}

	public Tecnico createTecnico(Tecnico tecnico) throws Exception {
		Long id = tecnico.getIdUsuario().getId();
		Optional<Usuario> usuario = this.usuarioService.findById(id);
		Tecnico novo = this.repository.findByIdUsuario(id);
		if (!usuario.isPresent()) {
			throw new Exception("Usuário não encontrado, impossível cadastrar técnico");
		}
		if (novo != null) {
			throw new Exception("Técnico já cadastrado");
		}
		return this.repository.save(tecnico);
	}

	public Tecnico alterTecnico(Tecnico tecnico) throws Exception {
		var nova = this.repository.findById(tecnico.getId());
		if (!nova.isPresent()) {
			throw new Exception(
					"Técnico com o id " + tecnico.getId() + " não encontrado(a), impossíve atualizar");
		}
		return this.repository.save(tecnico);
	}

}
