package com.saganet.school.database.entities.mdm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(schema="mdm", name = "grupos_profesores")
	private List<ProfesorEO> profesores = new ArrayList<>();
	
	public List<ProfesorEO> addProfesor(ProfesorEO profesor) {
		profesores.add(profesor);
	        return profesores;
	}
	
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
