package com.apirest.chamados.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apirest.chamados.model.Pagina;
import com.apirest.chamados.model.Regra;
import com.apirest.chamados.repository.RegraRepository;
import com.apirest.chamados.specification.RegraSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegraService {

	@Autowired
	private RegraRepository repository;

	@Autowired
	private PaginaService paginaService;

	public List<Regra> findAll(final Long id, final String descricao, final Boolean ativo) throws Exception {
		List<Regra> regra = new ArrayList<>();
		regra = repository.findAll(where(RegraSpecification.idRegra(id))
				.and(RegraSpecification.descricaoRegra(descricao)).and(RegraSpecification.ativoRegra(ativo)));
		if (regra.size() == 0) {
			throw new Exception("Não há dados");
		}
		return regra;
	}

	public Optional<Regra> findById(final Long id) throws Exception {
		final var regra = repository.findById(id);
		if (!regra.isPresent()) {
			throw new Exception("Regra com o id " + id + " não encontrada");
		}
		if (regra.get().getIdPagina().size() > 0) {
			regra.get().setIdPagina(this.paginaService.ordenaPagina(regra.get().getIdPagina()));
		}
		return regra;
	}

	public Regra createRegra(final Regra regra) throws Exception {
		final var duplicated = this.repository.findByDescricao(regra.getDescricao());
		if (duplicated != null) {
			throw new Exception("Regra com a descrição " + regra.getDescricao() + " já cadastrado");
		}
		regra.setIdPagina(this.corrigePaginas(regra.getIdPagina(), 0L));
		return this.repository.save(regra);
	}

	public Regra alterRegra(final Regra regra) throws Exception {
		final var nova = this.repository.findById(regra.getId());
		if (!nova.isPresent()) {
			throw new Exception("Regra com o id + " + regra.getId() + " não encontrada, impossíve atualizar");
		}
		regra.setIdPagina(this.corrigePaginas(regra.getIdPagina(), regra.getId()));
		return this.repository.save(regra);
	}

	public List<Pagina> corrigePaginas(List<Pagina> paginas, Long idRegra) throws Exception {
		
		List<Pagina> baseDB = this.paginaService.findAll();
		List<Pagina> novas = new ArrayList<>();
		
		if (idRegra != 0) {
			Regra regra = this.repository.findById(idRegra).get();
			regra.setIdPagina(new ArrayList<Pagina>());
			this.repository.save(regra);
		}
		
		if (paginas.size() > 0) {
			for (Pagina item : paginas) {
				Optional<Pagina> novaDB = null;
				if (item.getParent() != 0) {
					novaDB = baseDB.stream().filter(nova -> nova.getId() == item.getParent()).findFirst();
					novas.add(novaDB.get());
				}
			}
		}
		paginas.addAll(novas);
		
		Optional<Pagina> dash = paginas.stream().filter(page -> page.getId() == 3).findFirst();
		if (!dash.isPresent()) {
			paginas.add(this.paginaService.findById(3L).get());
		}

		List<Pagina> unique = new ArrayList<Pagina>();
		for (Pagina item : paginas) {
			var pag = unique.stream().filter(filter -> filter.getId() == item.getId()).findFirst();
			if (!pag.isPresent()) {
				unique.add(item);
			}
		}
		return unique;
	}

	public void deleteRegra(final Long id) throws Exception {
		final var nova = this.repository.findById(id);
		if (!nova.isPresent()) {
			throw new Exception("Regra com o id " + id + " não encontrada, impossível excluir");
		}
		this.repository.deleteById(id);
	}
}
