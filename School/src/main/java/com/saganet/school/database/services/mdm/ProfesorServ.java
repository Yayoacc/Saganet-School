package com.saganet.school.database.services.mdm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saganet.school.database.daos.mdm.ProfesorDao;
import com.saganet.school.database.entities.mdm.ProfesorEO;
import com.saganet.school.utils.Modelo;


import lombok.extern.slf4j.Slf4j;

@Service("ProfesorServ")
@Slf4j
public class ProfesorServ {
	
	@Autowired
	private ProfesorDao profesorDao;
	
	@Autowired
	private DireccionServ direccionServ;
	
	public Modelo<ProfesorEO> modeloProf(){
		List<ProfesorEO> listado;
		listado=profesorDao.findAll();
		
		return new Modelo<>(listado);
	}
	
	public ProfesorEO nuevo() {
		return new ProfesorEO();
	}
	
	public void guardar(ProfesorEO profesor) {
		log.debug("Se guarda/actualiza profesor: {}", profesor);
		direccionServ.guardar(profesor.getDireccion());
		profesorDao.save(profesor);
	}
	
//	public void asignarGrupo(ProfesorEO p, GrupoEO g) {
//		p.asignarGrupo(g);
//	}
}
