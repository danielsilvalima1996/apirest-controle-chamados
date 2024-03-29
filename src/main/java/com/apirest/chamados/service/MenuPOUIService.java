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
		List<MenuPOUI> menu = new ArrayList<>();
		if (paginas.size() > 0) {
			List<Pagina> parent = paginas.stream().filter(item -> item.getParent() == 0).collect(Collectors.toList());
			List<Pagina> children = paginas.stream().filter(item -> item.getParent() != 0).collect(Collectors.toList());
			for (Pagina p : parent) {
				menu.add(new MenuPOUI(p.getId(), p.getIcon(), p.getLabel(), p.getShortLabel(), p.getLink(),
						new ArrayList<>()));
			}
			for (Pagina p : children) {
				MenuPOUI pai = menu.stream().filter(item -> item.getId() == p.getParent()).findFirst().get();
				List<MenuPOUI> aux = pai.getSubItems();
				aux.add(new MenuPOUI(p.getId(), p.getIcon(), p.getLabel(), p.getShortLabel(), p.getLink(),
						new ArrayList<>()));
				aux = aux.stream().sorted((a, b) -> a.getLabel().compareTo(b.getLabel())).collect(Collectors.toList());
				pai.setSubItems(aux);
			}
		}
		return menu;
	}

}
