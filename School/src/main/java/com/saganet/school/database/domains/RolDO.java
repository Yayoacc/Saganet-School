package com.saganet.school.database.domains;

public enum RolDO {
	USER("Usuario"),
	ADMIN("Administrador");
	private final String nombre;

	private RolDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
