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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.saganet.school.auditory.AuditObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "mdm", name = "grupos")
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class GrupoEO extends AuditObject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(columnDefinition = "text")
	@NotBlank(message = "Falta nombre de grupo")
	private String nombre;

	private Integer Cupo;

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(schema = "mdm", name = "grupos_alumnos")
	private List<AlumnoEO> alumnos = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@JoinTable(schema = "mdm", name = "grupos_profesores")
	private List<ProfesorEO> profesores = new ArrayList<>();

	public String evaluaCupo(int noAlumnos) {
		int cupoRestante=Cupo - alumnos.size();
		String nota="";
		if(noAlumnos<=cupoRestante) {
			nota="cupo";
		}
		else {
			nota="Ya no hay lugares disponibles";
			if(cupoRestante!=0) {
				nota="Unicamente "+cupoRestante+" lugar(es) disponibles";
			}
		}
		return nota;
	}	
	
	public void addAlumno(List<AlumnoEO> alumno) {
		alumnos.addAll(alumno);
	}

	public void addProfesor(ProfesorEO profesor) {
		profesores.add(profesor);
	}

	public void borrarProfesor(ProfesorEO profesor) {
		profesores.remove(profesor);
	}
	
	public boolean existeProfesor(ProfesorEO profesor) {
		boolean existe = false;
		if (profesores.indexOf(profesor) != -1) {
			existe = true;
		}
		return existe;
	}

	public List<AlumnoEO> borrarAlumno(AlumnoEO alumno) {
		alumnos.remove(alumno);
		return alumnos;
	}
}
