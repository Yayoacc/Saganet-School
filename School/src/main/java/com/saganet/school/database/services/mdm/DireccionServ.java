package com.saganet.school.database.services.mdm;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saganet.school.database.daos.mdm.DireccionDao;
import com.saganet.school.database.entities.mdm.DireccionEO;

import lombok.extern.slf4j.Slf4j;

@Service("DireccionServ")
@Slf4j
public class DireccionServ {
	
	@Autowired
	private	DireccionDao direccionDao;
	
	public void guardar(DireccionEO direccion) {
		log.debug("Direccion a guardar: {}", direccion);
		direccionDao.save(direccion);
		log.debug("Direccion guardada: {}", direccion);
	}
	
	public DireccionEO buscarPorId(Integer id) {
		Optional<DireccionEO> optional;
		optional = direccionDao.findById(id);
		return optional.get();
	}
}
