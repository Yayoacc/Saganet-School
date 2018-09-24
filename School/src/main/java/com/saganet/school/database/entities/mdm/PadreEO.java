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
import com.saganet.school.auditory.AuditObject;
import com.saganet.school.database.domains.GeneroDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Table(schema = "mdm", name = "padres")
@Data
@EqualsAndHashCode(callSuper = false)
public class PadreEO extends AuditObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(columnDefinition = "text")
	private String nombre;

	@Column(columnDefinition = "text")
	private String primerApellido;

	@Column(columnDefinition = "text")
	private String segundoApellido;

	@Temporal(TemporalType.DATE)
	private Calendar fechaNacimiento;

	@Enumerated(EnumType.STRING)
	private GeneroDO genero;
	
	@Column(columnDefinition = "text")
	private String numeroTelefono;
	
	@Column(columnDefinition = "text")
	private String correoElectronico;
	
	@Column(columnDefinition = "text")
	private String parentesco;
	
	@OneToOne
	private DireccionEO direccion;
	
	// ===== Funciones propias =====
		public PadreEO() {
			direccion = new DireccionEO();
		}
}
