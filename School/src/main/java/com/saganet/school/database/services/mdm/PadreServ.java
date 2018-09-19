package com.saganet.school.database.services.mdm;

import java.util.List;
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
}
