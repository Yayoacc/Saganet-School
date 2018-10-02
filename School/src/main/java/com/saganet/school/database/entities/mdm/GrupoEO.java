package com.saganet.school.database.entities.mdm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.saganet.school.auditory.AuditObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema="mdm", name = "grupos")
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class GrupoEO extends AuditObject{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(columnDefinition = "text")
	@NotBlank(message = "Falta nombre de grupo")
	private String nombre;
	
	private Integer Cupo;
	
//	@ManyToMany
//	@JoinTable(schema="mdm")
//	private List<ProfesorEO> profesor = new ArrayList<>();
//	
//	@ManyToMany
//	@JoinTable(schema="mdm")
//	private List<AlumnoEO> alumno;
	
//	public void nuevoProfesor(ProfesorEO p) {
//		profesor.add(p);
//	}
}
