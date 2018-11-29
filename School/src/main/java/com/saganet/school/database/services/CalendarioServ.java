package com.saganet.school.database.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.primefaces.model.ScheduleModel;
import org.springframework.stereotype.Service;

import com.saganet.school.database.daos.mdm.EventoDao;
import com.saganet.school.database.entities.mdm.GrupoEO;
import com.saganet.school.database.entities.mdm.EventoEO;
import com.saganet.school.utils.ModeloCalendario;

@Service("CalendarioServ")
public class CalendarioServ {

	@Autowired
	private EventoDao eventoDao;
//	private static EventoDao eventDao;

	public ModeloCalendario nuevo(GrupoEO grupo) {
		List<EventoEO> ev = eventoDao.findByGrupo(grupo);
		ModeloCalendario modelo = new ModeloCalendario(ev, grupo);
		return modelo;
	}

	public void guardar(ModeloCalendario modelo) {

		EventoEO e = new EventoEO();;
		e.setDescripcion(modelo.getEvent().getTitle());
		e.setInicio(modelo.getEvent().getStartDate());
		e.setFin(modelo.getEvent().getEndDate());
		e.setGrupo(modelo.getGrupo());
		if (!modelo.isSeleccionado()) {
			eventoDao.save(e);
			modelo.agregarEvento();
		}
		else {
			e.setId((Integer)modelo.getEvent().getData());
			eventoDao.save(e);
		}
		System.out.println("Guardado");
	}
	
	public void eliminar(ModeloCalendario modelo) {
		eventoDao.deleteById((Integer)modelo.getEvent().getData());
	}
	
	public void mover(ModeloCalendario modelo) {
		System.out.println("Entre");
		
		List<EventoEO> even = eventoDao.findByIdAndGrupo(modelo.getId(), modelo.getGrupo());
		EventoEO e = even.get(0);
		e.setDescripcion(modelo.getTitulo());
		e.setInicio(modelo.getInicio());
		e.setFin(modelo.getFin());
		eventoDao.save(e);
		System.out.println("Id: "+e.getId());//+"Titulo: "+e.getDescripcion()+"Inicio: "+e.getInicio()+"Fin: "+e.getFin());
	}
	

	public List<EventoEO> eventos() {
		List<EventoEO> ev = eventoDao.findAll();
		return ev;
	}

}
