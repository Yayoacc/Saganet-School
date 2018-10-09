package com.saganet.school.database.entities.mdm;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.saganet.school.auditory.AuditObject;
import com.saganet.school.database.domains.GeneroDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Table(schema="mdm", name="profesores")
@Data
@EqualsAndHashCode(callSuper=false)
public class ProfesorEO extends AuditObject{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotBlank(message="Falta nombre")
	@Column(columnDefinition="text")
	private String nombre;
	
	@NotBlank(message="Falta primer apellido")
	@Column(columnDefinition="text")
	private String primerApellido;
	
	@NotBlank(message="Falta segundo apellido")
	@Column(columnDefinition="text")
	private String segundoApellido;
	
	@Enumerated(EnumType.STRING)
	private GeneroDO genero;
	
	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;
	
	@NotBlank(message="Falta rfc")
	@Column(columnDefinition="text")
	private String rfc;
	
	@Column(columnDefinition="text")
	private String telefono;
	
	@OneToOne
	private DireccionEO direccion;
	
	public ProfesorEO() {
		direccion = new DireccionEO();
	}
	
	public String getNombreCompleto() {
		StringBuilder b = new StringBuilder();
		b.append(nombre)
		.append(" ")
		.append(primerApellido)
		.append(" ")
		.append(segundoApellido);
		return b.toString();
	}
}
