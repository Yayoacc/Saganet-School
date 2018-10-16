package com.saganet.school.database.services.mdm;

import java.util.List;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saganet.school.database.daos.mdm.GrupoDao;
import com.saganet.school.database.entities.mdm.AlumnoEO;
import com.saganet.school.database.daos.mdm.ProfesorDao;
import com.saganet.school.database.entities.mdm.GrupoEO;
import com.saganet.school.database.entities.mdm.ProfesorEO;
import com.saganet.school.utils.Modelo;

@Service("GrupoServ")
public class GrupoServ {
	@Autowired
	GrupoDao grupoDao;
	@Autowired
	ProfesorDao profesorDao;

	public Modelo<GrupoEO> modeloTodos() {
		List<GrupoEO> listado;
		listado = grupoDao.findAll();
		return new Modelo<>(listado);
	}

	public GrupoEO nuevo() {
		return new GrupoEO();
	}

	public void guardar(GrupoEO grupo) {
		grupoDao.save(grupo);
	}

	public void addAlumnos(List<AlumnoEO> alumno, GrupoEO grupo) {
		List<AlumnoEO> repetidos = grupo.addAlumno(alumno);
		//grupoDao.flush();
		StringBuilder builder;
		builder = new StringBuilder();
		if (!repetidos.isEmpty()) {
			for(AlumnoEO al : repetidos) {
					if(repetidos.indexOf(al)  == repetidos.size()-1) {
						builder.append(al.getNombreCompleto());
						builder.append(".");
					}
					else {
						builder.append(al.getNombreCompleto());
						builder.append(", ");
					}
			}	
			mensaje(builder.toString());
		}
		
	}
	public void save(GrupoEO grupo) {
		grupoDao.save(grupo);
	}
	
	
	public void borrarAlumnos(AlumnoEO alumno, GrupoEO grupo) {
		grupo.borrarAlumno(alumno);
		//grupoDao.save(grupo);
	}

	public Modelo<AlumnoEO> AlumnosGrupo(GrupoEO grupo) {
		List<AlumnoEO> listado;
		listado = grupo.getAlumnos();
		return new Modelo<>(listado);
	}

	public void addProfesores(ProfesorEO profesor, GrupoEO grupo) {
		if(!grupo.existeProfesor(profesor)) {
			grupo.addProfesor(profesor);
//			grupoDao.save(grupo);
		}
		else {
			mensaje(profesor.getNombreCompleto());
		}
	}
	
	public void mensaje(String nombre) {
		if(!nombre.substring(0, 5).equals("javax")) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("Ya existe(n)", nombre+" ya esta(n) asignado(s) al grupo"));
		}
	}

	public void borrarProfesor(ProfesorEO profesor, GrupoEO grupo) {
		grupo.borrarProfesor(profesor);
//		grupoDao.save(grupo);
//		grupoDao.flush();
	}
	

	public Modelo<ProfesorEO> ProfesoresGrupo(GrupoEO grupo) {
		List<ProfesorEO> listado;
		listado = grupo.getProfesores();
		return new Modelo<>(listado);
	}
}
