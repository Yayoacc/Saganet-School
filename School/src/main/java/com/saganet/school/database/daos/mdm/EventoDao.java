package com.saganet.school.database.daos.mdm;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saganet.school.database.entities.mdm.EventoEO;
import com.saganet.school.database.entities.mdm.GrupoEO;

public interface EventoDao extends JpaRepository<EventoEO, Integer>{
	public List<EventoEO> findByGrupo(GrupoEO grupo);
	
	public List<EventoEO> findByIdAndGrupo(Integer id, GrupoEO grupo);
	
	public EventoEO findByDescripcionAndGrupo(String Des, GrupoEO g);
	
}
