package com.saganet.school.database.entities.mdm;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.saganet.school.auditory.AuditObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema="mdm", name = "relGrupoAlumno")
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class RelGrupoAlumno extends AuditObject{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany
	private AlumnoEO alumno;
	
	@OneToMany
	private GrupoEO grupo;
}