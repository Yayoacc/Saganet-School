package com.saganet.school.database.domains;

public enum GeneroDO {
	HOMBRE("Hombre"),
	MUJER("Mujer");
	
	private final String nombre;

	private GeneroDO(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}
