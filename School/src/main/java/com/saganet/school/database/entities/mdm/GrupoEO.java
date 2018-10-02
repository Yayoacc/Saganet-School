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
	@JoinTable(schema="mdm", name = "grupos_alumnos")
	private List<AlumnoEO> alumnos = new ArrayList<>();
	
	public List<AlumnoEO> addAlumno(AlumnoEO alumno) {
	        alumnos.add(alumno);
	        return alumnos;
	}
//	public void removeAlumno(AlumnoEO alumno) {
//        alumnos.remove(alumno);
//    }
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof GrupoEO)) return false;
//        return id != null && id.equals(((GrupoEO) o).id);
//    }
//	@Override
//    public int hashCode() {
//        return 31;
//    }	
}
