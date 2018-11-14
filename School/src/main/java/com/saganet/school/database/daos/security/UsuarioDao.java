package com.saganet.school.database.daos.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saganet.school.database.entities.security.UsuarioEO;

public interface UsuarioDao extends JpaRepository<UsuarioEO, String>{
	public List<UsuarioEO> findByUsuario(String Usuario);
	public List<UsuarioEO> findAll();
}
