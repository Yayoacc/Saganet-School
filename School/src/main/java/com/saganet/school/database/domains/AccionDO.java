package com.saganet.school.database.domains;

public enum AccionDO {
	INSERT("Insertar"),
	UPDATE("Actualizar"),
	DELETE("Borrar");
	
	public String getNombre() {
		return nombre;
	}

	private final String nombre;

	private AccionDO(String nombre) {
		this.nombre = nombre;
	}
}
