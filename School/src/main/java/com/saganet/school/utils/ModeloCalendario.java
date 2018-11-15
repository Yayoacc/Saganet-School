package com.saganet.school.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import com.saganet.school.database.entities.mdm.EventoEO;
import com.saganet.school.database.entities.mdm.GrupoEO;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class ModeloCalendario implements Serializable {
	private ScheduleModel modelo;
	private ScheduleEvent event;
	private String titulo;
	private Date inicio;
	private Date fin;
	private GrupoEO grupo;
	private boolean seleccionado;
	private int id;
	
	public ModeloCalendario(List<EventoEO> ev, GrupoEO grupo) {
		modelo = new DefaultScheduleModel();
		event = new DefaultScheduleEvent();
		seleccionado = false;
		
		this.grupo=grupo;
			for (EventoEO evento : ev) {
//				System.out.println(evento.getDescripcion()+" "+evento.getInicio()+" "+evento.getFin());
				modelo.addEvent(new DefaultScheduleEvent(evento.getDescripcion(), evento.getInicio(), evento.getFin(), evento.getId()));
			}
	}
	
	public ScheduleModel getModelo() {
		return modelo;
	}
	
	
	public void onDateSelect(SelectEvent selectEvent) {
		seleccionado=false;
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
	
	public void agregarEvento() {
        if(event.getId() == null)
            modelo.addEvent(event);
        else
            modelo.updateEvent(event);
        event = new DefaultScheduleEvent();
    }
	
	public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        seleccionado=true;
        
        System.out.println(event.getTitle() +" "+ event.getStartDate() +" "+ event.getEndDate()+" - "+(((Integer)this.event.getData())+1));
    }
	
	public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Evento movido","");
        this.event = (ScheduleEvent) event.getScheduleEvent();
        seleccionado=true;
        id=(Integer)this.event.getData();
        titulo=this.event.getTitle();
        inicio=this.event.getStartDate();
        fin=this.event.getEndDate();
//        System.out.println("Id del evento "+id + "Titulo del evento "+titulo +"inicio del evento "+inicio +"Fin del evento "+fin );

//        EventoEO even = eventoDao.findById(id);
//        even.setDescripcion(this.event.getTitle());
//        even.setInicio(this.event.getStartDate());
//        even.setFin(this.event.getEndDate());
//        eventoDao.save(even);
//        System.out.println(this.event.getTitle() +" "+ this.event.getStartDate() +" "+ this.event.getEndDate()+" "+this.event.getId());
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
	
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    
	
//	============================================================================
//	private Calendar today() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
// 
//        return calendar;
//    }
	
//	private Date previousDay8Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 8);
//         
//        return t.getTime();
//    }
//     
//    private Date previousDay11Pm() {
//        Calendar t = (Calendar) today().clone();
//        t.set(Calendar.AM_PM, Calendar.PM);
//        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
//        t.set(Calendar.HOUR, 11);
//        System.out.println("...::: TIEMPO :::...\n"+t.getTime());
//        return t.getTime();
//    }
}
