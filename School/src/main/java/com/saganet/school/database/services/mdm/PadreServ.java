package com.saganet.school.database.services.mdm;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.saganet.school.database.daos.mdm.PadreDao;
import com.saganet.school.database.entities.mdm.PadreEO;
import com.saganet.school.utils.Modelo;

@Service("PadreServ")
public class PadreServ {
	@Autowired PadreDao padreDao;
	@Autowired DireccionServ direccionServ;
	public Modelo<PadreEO> modeloTodos(){
		List<PadreEO> listado;
		listado = padreDao.findByOrderByPrimerApellidoAscSegundoApellidoAscNombreAsc();
		return new Modelo<>(listado);
	}
	public  PadreEO nuevo() {
		return new PadreEO();
	}
	public void guardar(PadreEO padre) {
		direccionServ.guardar(padre.getDireccion());
		padreDao.save(padre);
	}
	public void eliminarPadre(PadreEO padre) {
		try {
			padreDao.delete(padre);
		} catch (Exception e) {
			mensaje(padre.getNombreCompleto());
		}
	}
	
	public void mensaje(String nombre) {
		if(!nombre.substring(0, 5).equals("javax")) {
			FacesContext context = FacesContext.getCurrentInstance();
	        context.addMessage(null, new FacesMessage("No se puede eliminar", nombre+" es padre de un alumno registrado"));
		}
	}
}
