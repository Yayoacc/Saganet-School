package com.saganet.school.database.entities.mdm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	//===== FUNCIONES EXTRAS ==============0
	@JsonIgnore
	public String getDireccionCompleta() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Calle ")
			.append(calle)
			.append(", colonia ")
			.append(colonia)
			.append(", No. Ext: ")
			.append(numeroExterior)
			.append(", No. Int: ")
			.append(numeroInterior)
			.append(", CP: ")
			.append(codigoPostal);
		return builder.toString();
	}
}


