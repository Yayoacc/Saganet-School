package com.saganet.school.database.services.mdm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saganet.school.database.daos.mdm.GrupoProfesorDao;
import com.saganet.school.database.entities.mdm.GrupoProfesorEO;
import com.saganet.school.utils.Modelo;

import lombok.extern.slf4j.Slf4j;

@Service("GrupoProfesorServ")
@Slf4j
public class GrupoProfesorServ {
	@Autowired
	private GrupoProfesorDao grupoProfesorDao;

	public Modelo<GrupoProfesorEO> modeloTodos(){
		List<GrupoProfesorEO> listado;
		listado = grupoProfesorDao.findAll();
		
		return new Modelo<>(listado);
	}
	
	public GrupoProfesorEO nuevo() {
		return new GrupoProfesorEO();
	}
	
	public void guardar(GrupoProfesorEO gp) {
		try {
		log.debug("Se guarda grupoProfesor {}", gp);
		grupoProfesorDao.save(gp);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
