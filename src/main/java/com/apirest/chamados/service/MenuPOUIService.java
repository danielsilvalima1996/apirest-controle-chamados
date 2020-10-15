package com.apirest.chamados.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.apirest.chamados.model.MenuPOUI;
import com.apirest.chamados.model.Pagina;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuPOUIService {

	@Autowired
	private RegraService regraService;

	public List<MenuPOUI> criaMenu(Long idRegra) throws Exception {
		List<Pagina> paginas = this.regraService.findById(idRegra).get().getIdPagina();
		paginas.stream().sorted((a, b) -> a.getParent().compareTo(b.getParent()));
		List<MenuPOUI> menu = new ArrayList<>();
		for (Pagina p : paginas) {
			if (p.getParent() == 0) {
				menu.add(new MenuPOUI(p.getId(), p.getIcon(), p.getLabel(), p.getShortLabel(), p.getLink(),
						new ArrayList<>()));
			} else {
				MenuPOUI pai = menu.stream().filter(item -> item.getId() == p.getParent()).findFirst().get();
				List<MenuPOUI> aux = pai.getSubItems();
				aux.add(new MenuPOUI(p.getId(), p.getIcon(), p.getLabel(), p.getShortLabel(),
						p.getLink(), new ArrayList<>()));
				aux = aux.stream().sorted((a, b) -> a.getLabel().compareTo(b.getLabel())).collect(Collectors.toList());
				pai.setSubItems(aux);
			}
		}
		return menu;
	}

}
