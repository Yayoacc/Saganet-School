package com.saganet.school.database.entities.mdm;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.saganet.school.database.domains.GeneroDO;

@Entity
@Table(schema="mdm", name="alumnos")
@SuppressWarnings("serial")
public class AlumnoEO implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message = "Falta Nombre")
	@Column(columnDefinition="text")
	private String nombre;
	
	@NotBlank(message = "Falta Primer Apellido")
	@Column(columnDefinition="text")
	private String primerApellido;
	
	@Column(columnDefinition="text")
	private String segundoApellido;
	
	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;
	
	@Enumerated(EnumType.STRING)
	private GeneroDO genero;
	
	// ===== Funciones propias =====
	public String getNombreCompleto() {
		StringBuilder builder;
		
		builder = new StringBuilder();
		
		builder.append(nombre)
			.append(" ")
			.append(primerApellido)
			.append(" ")
			.append(segundoApellido);
		
		return builder.toString();		
	}

	@Override
	public String toString() {
		return "AlumnoEO [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Calendar getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Calendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public GeneroDO getGenero() {
		return genero;
	}

	public void setGenero(GeneroDO genero) {
		this.genero = genero;
	}
	
}
