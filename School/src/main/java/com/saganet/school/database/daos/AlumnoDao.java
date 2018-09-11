package com.saganet.school.database.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saganet.school.database.entities.AlumnoEO;

public interface AlumnoDao extends JpaRepository<AlumnoEO, Integer> {
	
}
