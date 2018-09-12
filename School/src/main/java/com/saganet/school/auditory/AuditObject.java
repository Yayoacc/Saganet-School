package com.saganet.school.auditory;

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

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("serial")
@Data
public abstract class AuditObject implements Serializable {
	
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
}
