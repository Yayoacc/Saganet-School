package com.saganet.school.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Modelo<Entity> implements Serializable {

	private List<Entity> listado;
	private Entity seleccionado;

	// ===== Constructores =====
	public Modelo() {
		super();
		listado = new ArrayList<Entity>();
		seleccionado = null;
	}

	public Modelo(List<Entity> listado) {
		super();
		this.listado = listado;
		if(this.listado != null)
			if(!this.listado.isEmpty())
				this.seleccionado = this.listado.get(0);
	}

	public Modelo(List<Entity> listado, Entity seleccionado) {
		super();
		this.listado = listado;
		this.seleccionado = seleccionado;
	}
	
	
	// ===== Getters & Setters =====
	
	public List<Entity> getListado() {
		return listado;
	}

	public void setListado(List<Entity> listado) {
		this.listado = listado;
	}

	public Entity getSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(Entity seleccionado) {
		this.seleccionado = seleccionado;
	}

}
