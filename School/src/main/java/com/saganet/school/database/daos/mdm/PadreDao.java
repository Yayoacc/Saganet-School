package com.saganet.school.database.daos.mdm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saganet.school.database.entities.mdm.PadreEO;

public interface PadreDao extends JpaRepository<PadreEO, Integer>{
	public List<PadreEO> findByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();
}
