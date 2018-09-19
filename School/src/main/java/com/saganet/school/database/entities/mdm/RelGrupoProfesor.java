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
@Table(schema="mdm", name = "relGrupoProfesor")
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class RelGrupoProfesor extends AuditObject{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany
	private ProfesorEO profesor;
	
	@OneToMany
	private GrupoEO grupo;
}