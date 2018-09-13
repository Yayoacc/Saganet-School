package com.saganet.school.database.services.mdm;

import java.util.List;

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
	
	public Modelo<AlumnoEO> modeloTodos(){
		List<AlumnoEO> listado;
		
		listado = alumnoDao.findByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();
		log.debug("Registros en listado: {}", listado.size());
		
		return new Modelo<>(listado);
	}
	
	public AlumnoEO nuevo() {
		return new AlumnoEO();
	}
	
	public void guardar(AlumnoEO alumno) {
		log.debug("Se guarda/actualiza alumno: {}", alumno);
		alumnoDao.save(alumno);
	}
	
}
