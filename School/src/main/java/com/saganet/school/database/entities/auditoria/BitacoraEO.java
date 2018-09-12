package com.saganet.school.database.entities.auditoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.saganet.school.auditory.AuditObject;
import com.saganet.school.database.domains.AccionDO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema="auditoria", name="bitacora")
@EntityListeners(AuditingEntityListener.class)
@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
public class BitacoraEO extends AuditObject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private AccionDO accion;
	
	@Column(columnDefinition="text")
	private String objeto;

	public BitacoraEO(AccionDO accion, String objeto) {
		super();
		this.accion = accion;
		this.objeto = objeto;
	}
	
}
