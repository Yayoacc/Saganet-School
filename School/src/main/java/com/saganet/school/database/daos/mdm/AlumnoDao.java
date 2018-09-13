package com.saganet.school.database.daos.mdm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saganet.school.database.entities.mdm.AlumnoEO;

public interface AlumnoDao extends JpaRepository<AlumnoEO, Integer> {
	
//	Obten todos los registros ordenados por PrimerApellido, SegundoApellido y Nombre
	public List<AlumnoEO> findByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();

//	Obten los primeros 10 registros ordenados por PrimerApellido, SegundoApellido y Nombre
	public List<AlumnoEO> findFirst10ByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();
}
