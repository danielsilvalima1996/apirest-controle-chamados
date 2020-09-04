package com.apirest.chamados.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.chamados.model.Tecnico;
import com.apirest.chamados.repository.TecnicoRepository;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public List<Tecnico> findAll(Long id, Boolean ativo, Long idUsuario) throws Exception {
//		List<Tecnico> tecnico = new ArrayList<>();
//		tecnico = repository.findAll(
//				where(TecnicoSpecification.idTecnico(id))
//				.and(TecnicoSpecification.ativoTecnico(ativo))
//				.and(TecnicoSpecification.idTecnicoUsuario(idUsuario))
//				);
//		if (tecnico.size() == 0) {
//			throw new Exception("Não há dados");
//		}
//		return tecnico;
		return this.repository.findAll();
	}

	public Optional<Tecnico> findById(Long id) throws Exception {
		var tecnico = repository.findById(id);
		if (!tecnico.isPresent()) {
			throw new Exception("Técnico com o id " + id + " não encontrado");
		}
		return tecnico;
	}

	public Tecnico createTecnico(Tecnico tecnico) throws Exception {
//		var duplicated = this.repository.findById(tecnico.getId());
//		if (duplicated.isPresent()) {
//			System.out.println(duplicated.toString());
//			throw new Exception("Técnico " + duplicated.get().getIdUsuario().getNomeCompleto() + 
//					" já cadastrado como analista");
//		}
		return this.repository.save(tecnico);
	}
	
	public Tecnico alterTecnico(Tecnico tecnico) throws Exception {
		var nova = this.repository.findById(tecnico.getId());
		if (!nova.isPresent()) {
			throw new Exception("Técnico com o id + " + tecnico.getId() + " não encontrado, impossíve atualizar");
		}
		tecnico.setIdUsuario(nova.get().getIdUsuario());
		return this.repository.save(tecnico);
	}

	public void deleteTecnico(Long id) throws Exception {
		var nova = this.repository.findById(id);
		if (!nova.isPresent()) {
			throw new Exception("Técnico com o id " + id + " não encontrado, impossível excluir");
		}
		this.repository.deleteById(id);
	}
}
