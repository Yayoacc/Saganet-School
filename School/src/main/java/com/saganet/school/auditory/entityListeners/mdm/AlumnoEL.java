package com.saganet.school.auditory.entityListeners.mdm;

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.saganet.school.auditory.BeanAuditory;
import com.saganet.school.database.domains.AccionDO;
import com.saganet.school.database.entities.auditoria.BitacoraEO;
import com.saganet.school.database.entities.mdm.AlumnoEO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlumnoEL {
	
	@PrePersist
	public void prePersist(AlumnoEO alumno) {
		bitacora(AccionDO.INSERT, alumno);
	}
	
	@PreUpdate
	public void preUpdate(AlumnoEO alumno) {
		log.debug("Bitácora, saveState: {}", alumno.getSavedState());
		bitacora(AccionDO.UPDATE, alumno.getSavedState());
	}
	
	@Transactional(value=TxType.MANDATORY)
	private void bitacora(AccionDO accion, AlumnoEO alumno) {
		EntityManager entityManager = BeanAuditory.getBean(EntityManager.class);
		entityManager.persist(new BitacoraEO(accion, alumno.toString()));
	}
	
}
