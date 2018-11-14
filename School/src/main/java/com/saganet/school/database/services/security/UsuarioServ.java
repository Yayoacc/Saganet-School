package com.saganet.school.database.services.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saganet.school.database.daos.security.UsuarioDao;
import com.saganet.school.database.entities.security.UsuarioEO;
import com.saganet.school.utils.Modelo;

@Service("UsuarioServ")
public class UsuarioServ {
	@Autowired UsuarioDao usuarioDao;
	public  UsuarioEO nuevo() {
		return new UsuarioEO();
	}
	public void guardar(UsuarioEO usuario) {
		usuarioDao.save(usuario);
	}
	public void eliminar(UsuarioEO usuario) {
		usuarioDao.delete(usuario);
	}
	public UsuarioEO cargarUsuario(String Usuario) {
		List<UsuarioEO> usuarioL = usuarioDao.findByUsuario(Usuario);
		UsuarioEO usuario = usuarioL.get(0);
		return usuario;
	}
	public Modelo<UsuarioEO> modeloTodos() {
		List<UsuarioEO> listado;
		listado = usuarioDao.findAll();
		return new Modelo<>(listado);
	}
}
