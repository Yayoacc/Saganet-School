package com.saganet.school.database.daos.mdm;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saganet.school.database.entities.mdm.GrupoEO;

public interface GrupoDao extends JpaRepository<GrupoEO, Integer> {
}
