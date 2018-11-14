package com.saganet.school.database.entities.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.saganet.school.auditory.AuditObject;
import com.saganet.school.database.domains.RolDO;
import com.saganet.school.database.entities.mdm.ProfesorEO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(schema = "sessions", name = "usuario")
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = false)
public class UsuarioEO extends AuditObject{
	
	@Id
	private String Id;
	
	@NotBlank(message = "Falta Usuario")
	@Column(columnDefinition = "text")
	private String usuario;
	
	@NotBlank(message = "Falta Contraseña")
	@Column(columnDefinition = "text")
	private String EncrytedPassword;
	
	@Enumerated(EnumType.STRING)
	private RolDO Rol;
	
	@NotBlank
	private Boolean Enabled;
	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private ProfesorEO profesor;
}
