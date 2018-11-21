package com.saganet.school.database.daos.mdm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saganet.school.database.entities.mdm.ProfesorEO;

public interface ProfesorDao extends JpaRepository<ProfesorEO, Integer> {

	List<ProfesorEO> findByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();

}
