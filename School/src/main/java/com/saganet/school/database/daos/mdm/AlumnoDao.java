package com.saganet.school.database.daos.mdm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saganet.school.database.entities.mdm.AlumnoEO;

public interface AlumnoDao extends JpaRepository<AlumnoEO, Integer> {
	
//	Obten todos los registros ordenados por PrimerApellido, SegundoApellido y Nombre
	public List<AlumnoEO> findByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();

//	Obten los primeros 100 registros ordenados por PrimerApellido, SegundoApellido y Nombre
	public List<AlumnoEO> findFirst100ByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();
	
//	Obten todos los registros filtrando por Primer Apellido y Ordenando por PrimerApellido, SegundoApellido y Nombre
	public List<AlumnoEO> findByPrimerApellidoOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc(String primeroApellido);
	
//	Obten todos los registros filtrando por Primer Apellido y Segundo Apellido y Ordenando por PrimerApellido, SegundoApellido y Nombre
	public List<AlumnoEO> findByPrimerApellidoAndSegundoApellidoOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc(String primerApellido, String segundoApellido);
	
//	Obten todos los registros donde el Primer Apellido inicie por PARAMETRO y Ordenando por PrimerApellido, SegundoApellido y Nombre
	public List<AlumnoEO> findByPrimerApellidoStartsWithOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc(String inicioPrimerApellido);
	
}
