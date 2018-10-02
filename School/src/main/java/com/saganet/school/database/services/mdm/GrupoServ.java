package com.saganet.school.database.services.mdm;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saganet.school.database.daos.mdm.GrupoDao;
import com.saganet.school.database.entities.mdm.AlumnoEO;
import com.saganet.school.database.entities.mdm.GrupoEO;
import com.saganet.school.utils.Modelo;
@Service("GrupoServ")
public class GrupoServ {
	@Autowired GrupoDao grupoDao;
	
	public Modelo<GrupoEO> modeloTodos(){
		List<GrupoEO> listado;
		listado = grupoDao.findAll();
		return new Modelo<>(listado);
	}
	public  GrupoEO nuevo() {
		return new GrupoEO();
	}
	public void guardar(GrupoEO grupo) {
		grupoDao.save(grupo);
	}
	
	public void addAlumnos(AlumnoEO alumno, GrupoEO grupo) {
		List<AlumnoEO>alumnos = grupo.addAlumno(alumno);
		grupo.setAlumnos(alumnos);
		grupoDao.save(grupo);
	}
	public Modelo<AlumnoEO> AlumnosGrupo(GrupoEO grupo){
		List<AlumnoEO> listado;
		listado = grupo.getAlumnos();
		return new Modelo<>(listado);
	}
}
