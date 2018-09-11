package com.saganet.school.database.daos.mdm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saganet.school.database.entities.mdm.AlumnoEO;

public interface AlumnoDao extends JpaRepository<AlumnoEO, Integer> {
	
}
