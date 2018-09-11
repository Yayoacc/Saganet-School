package com.saganet.school.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesConverter("CalendarConverter")
public class CalendarConverter implements Converter {
	private static final Logger logger = LoggerFactory.getLogger(CalendarConverter.class);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Calendar calendario;
		SimpleDateFormat formato;
		
		logger.debug("getAsObject");
		logger.debug("context: {}", context);
		logger.debug("component: {}", component);
		logger.debug("value: {}", value);
		
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
		
		logger.debug("getAsString");
		logger.debug("context: {}", context);
		logger.debug("component: {}", component);
		logger.debug("value: {}", value);
		
		calendario = (Calendar) value;
		formato = new SimpleDateFormat("dd/MM/yyyy");
		
		return formato.format(calendario.getTime());
	}

}
