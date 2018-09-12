package com.saganet.school.database.entities.auditoria;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.saganet.school.database.domains.AccionDO;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(schema="auditoria", name="bitacora")
@EntityListeners(AuditingEntityListener.class)
@Data
public class BitacoraEO implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private AccionDO accion;
	
	@Column(columnDefinition="text")
	private String objeto;
	
	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createdDate;

	public BitacoraEO(AccionDO accion, String objeto) {
		super();
		this.accion = accion;
		this.objeto = objeto;
	}
}
