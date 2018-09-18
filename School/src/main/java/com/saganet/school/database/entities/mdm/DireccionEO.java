package com.saganet.school.database.entities.mdm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.saganet.school.auditory.AuditObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Table(schema="mdm", name="direcciones")
@Data
@EqualsAndHashCode(callSuper = false)
public class DireccionEO extends AuditObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(columnDefinition="text")
	private String calle;
	
	@Column(columnDefinition="text")
	private String colonia;
	
	@Column(columnDefinition="text")
	private String numeroExterior;
	
	@Column(columnDefinition="text")
	private String numeroInterior;
	
	private Integer codigoPostal;
}
