package com.saganet.school.database.entities.mdm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Embeddable
public class IdGrupoProfesor implements Serializable {
	@Column(name="grupo_id")
	private Integer grupo;
	@Column(name="profesor_id")
	private Integer profesor;
	
//	@Override
//	public boolean equals(Object instance) {
//		if (instance == null)
//			return false;
//
//		if (!(instance instanceof IdGrupoProfesor))
//			return false;
//
//		final IdGrupoProfesor other = (IdGrupoProfesor) instance;
//		if (!(grupo.getId().equals(other.getGrupo().getId())))
//			return false;
//
//		if (!(profesor.getId().equals(other.getProfesor().getId())))
//			return false;
//
//		return true;
//	}
//
//	@Override
//	public int hashCode() {
//		int hash = 7;
//		hash = 47 * hash + (this.grupo != null ? this.grupo.hashCode() : 0);
//		hash = 47 * hash + (this.profesor != null ? this.profesor.hashCode() : 0);
//		return hash;
//	}

}