package com.saganet.school.database.entities.mdm;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.saganet.school.auditory.AuditObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("serial")
@Entity
@Table(schema="mdm", name="grupoProfesor")
//@IdClass(value=IdGrupoProfesor.class)
@Data
@EqualsAndHashCode(callSuper = false)
public class GrupoProfesorEO extends AuditObject{
	@EmbeddedId
	private IdGrupoProfesor idGrupoProfesor;
	
	@ManyToOne
	@JoinColumn(name="grupo_id", insertable = false, updatable = false)
	private GrupoEO grupo;
	
	@ManyToOne
	@JoinColumn(name="profesor_id", insertable = false, updatable = false)
	private ProfesorEO profesor;

}
