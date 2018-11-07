package com.saganet.school.database.domains;

public enum RolDO {
	Usuario("ROLE_USER"),
	Administrador("ROLE_ADMIN");
	private final String nombre;

	private RolDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
