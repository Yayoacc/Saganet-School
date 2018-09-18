package com.saganet.school.database.mdm;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.saganet.school.database.daos.mdm.AlumnoDao;
import com.saganet.school.database.entities.mdm.AlumnoEO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AlumnoTest {

	@Autowired
	AlumnoDao alumnoDao;

	@Test
	public void query01() {
		List<AlumnoEO> listado;
		Optional<AlumnoEO> optionalAlumno;
		AlumnoEO alumno;
		int i;

		listado = alumnoDao.findFirst100ByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();
		
		assertEquals(100, listado.size());
		
		i = 1;
		for(AlumnoEO objeto : listado) {
//			log.debug("Alumno {}: {}", i++, objeto.getNombreCompleto());
		}
		
//		optionalAlumno = alumnoDao.findById(1);
//		
//		alumno = optionalAlumno.get();
//		assertEquals("Erick Sánchez Garnica", alumno.getNombreCompleto());
//		log.debug("Nombre por ID: {}", alumno.getNombreCompleto());
		
		listado = alumnoDao.findByPrimerApellidoOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc("SANCHEZ");
//		log.debug("Buscando por Primer Apellido: SANCHEZ ({})", listado.size());
		i = 1;
		for(AlumnoEO objeto : listado) {
//			log.debug("Alumno {}: {}", i++, objeto.getNombreCompleto());
		}
		
		listado = alumnoDao.findByPrimerApellidoAndSegundoApellidoOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc("SANCHEZ", "BAUTISTA");
//		log.debug("Buscando por Primer Apellido: SANCHEZ y Segundo Apellido: BAUTISTA ({})", listado.size());
		i = 1;
		for(AlumnoEO objeto : listado) {
//			log.debug("Alumno {}: {}", i++, objeto.getNombreCompleto());
		}
		
		listado = alumnoDao.findByPrimerApellidoStartsWithOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc("SANT");
//		log.debug("Buscando por Inicio de Primer Apellido: SANT ({})", listado.size());
		i = 1;
		for(AlumnoEO objeto : listado) {
//			log.debug("Alumno {}: {}", i++, objeto.getNombreCompleto());
		}
		
	}
}
