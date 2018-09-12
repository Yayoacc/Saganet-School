package com.saganet.school.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("CalendarConverter")
public class CalendarConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Calendar calendario;
		SimpleDateFormat formato;
		
		formato = new SimpleDateFormat("dd/MM/yyyy");
		calendario = Calendar.getInstance();
		try {
			calendario.setTime(formato.parse(value));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return calendario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Calendar calendario;
		SimpleDateFormat formato;
		
		calendario = (Calendar) value;
		formato = new SimpleDateFormat("dd/MM/yyyy");
		
		return formato.format(calendario.getTime());
	}

}
