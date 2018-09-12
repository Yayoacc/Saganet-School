package com.saganet.school.database.entities.mdm;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.saganet.school.auditory.AuditObject;
//import com.saganet.school.auditory.entityListeners.mdm.AlumnoEL;
import com.saganet.school.database.domains.GeneroDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "mdm", name = "alumnos")
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
//@EntityListeners(AlumnoEL.class)
public class AlumnoEO extends AuditObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotBlank(message = "Falta Nombre")
	@Column(columnDefinition = "text")
	private String nombre;

	@NotBlank(message = "Falta Primer Apellido")
	@Column(columnDefinition = "text")
	private String primerApellido;

	@Column(columnDefinition = "text")
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
}
