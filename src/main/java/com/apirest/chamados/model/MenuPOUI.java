package com.apirest.chamados.model;

import java.util.List;

public class MenuPOUI {

	private Long id;
	private String icon;
	private String label;
	private String shortLabel;
	private String link;
	private List<MenuPOUI> subItems;

	public MenuPOUI() {
	}

	public MenuPOUI(Long id, String icon, String label, String shortLabel, String link, List<MenuPOUI> subItems) {
		this.id = id;
		this.icon = icon;
		this.label = label;
		this.shortLabel = shortLabel;
		this.link = link;
		this.subItems = subItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getShortLabel() {
		return shortLabel;
	}

	public void setShortLabel(String shortLabel) {
		this.shortLabel = shortLabel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<MenuPOUI> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<MenuPOUI> subItems) {
		this.subItems = subItems;
	}

}
