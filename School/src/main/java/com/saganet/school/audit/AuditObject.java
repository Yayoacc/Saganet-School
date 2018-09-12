package com.saganet.school.database;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("serial")
public abstract class EntityObject implements Serializable {
	
	@CreatedBy
	protected String createdBy;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Calendar creationDate;
	
	@LastModifiedBy
	protected String lastModifiedBy;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Calendar lastModifiedDate;
	
	// ===== Funciones genéricas para comparación =====
	
	@Override
	public boolean equals(Object obj) {
		EntityObject check;

		check = (EntityObject) obj;

		if (this.getClass().equals(obj.getClass()))
			if (this.getId().equals(check.getId()))
				return true;

		return false;
	}

	@Override
	public int hashCode() {
		return getId();
	}
	
	// ===== Getters & Setters =====

	public Integer getId() {
		return 0;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Calendar lasModifiedDate) {
		this.lastModifiedDate = lasModifiedDate;
	}
	
}
