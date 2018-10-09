package com.saganet.school.database.services.mdm;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saganet.school.database.daos.mdm.AlumnoDao;
import com.saganet.school.database.entities.mdm.AlumnoEO;
import com.saganet.school.utils.Modelo;

import lombok.extern.slf4j.Slf4j;

@Service("AlumnoServ")
@Slf4j
public class AlumnoServ {

	@Autowired
	private AlumnoDao alumnoDao;

	@Autowired
	private DireccionServ direccionServ;

	public Modelo<AlumnoEO> modeloTodos() {
		List<AlumnoEO> listado;

		// listado =
		// alumnoDao.findFirst100ByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();
		listado = alumnoDao.findAll();
		return new Modelo<>(listado);
	}

	public void eliminarAlumno(AlumnoEO alumno) {
		try {
			alumnoDao.delete(alumno);
		} catch (Exception e) {
			mensaje(alumno.getNombreCompleto());
		}
	}
	
	public void mensaje(String nombre) {
		if(!nombre.substring(0, 5).equals("javax")) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("No se puede eliminar", nombre+" está asignado a un grupo"));
		}
	}

	public AlumnoEO nuevo() {
		return new AlumnoEO();
	}

	public void guardar(AlumnoEO alumno) {
		log.debug("Se guarda/actualiza alumno: {}", alumno);
		direccionServ.guardar(alumno.getDireccion());
		// padreServ.guardar(alumno.getPadre());
		alumnoDao.save(alumno);
	}

}
