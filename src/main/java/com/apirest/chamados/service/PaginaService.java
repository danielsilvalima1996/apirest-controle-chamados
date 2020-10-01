package com.apirest.chamados.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apirest.chamados.model.Pagina;
import com.apirest.chamados.repository.PaginaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaginaService {

	@Autowired
	private PaginaRepository repository;

	public List<Pagina> findAll() throws Exception {
		List<Pagina> paginas = new ArrayList<>();
		paginas = this.ordenaPagina(this.repository.findAll());
		return paginas;
	}

	public List<Pagina> ordenaPagina(List<Pagina> paginas) {
		if (paginas.size() > 0) {
			for (Pagina item : paginas) {
				if (item.getParent() != 0) {
					Pagina atual = new Pagina();
					atual = paginas.stream().filter(pag -> pag.getId() == item.getParent()).findFirst().get();
					item.setLink(atual.getLink() + item.getLink());
					atual = new Pagina();
				}
			}
			paginas.stream().sorted();
		}
		return paginas;
	}

	public Optional<Pagina> findById(Long id) {
		return this.repository.findById(id);
	}

}
