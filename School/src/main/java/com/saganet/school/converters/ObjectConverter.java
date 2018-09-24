package com.saganet.school.converters;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		String cadena;
		ObjectMapper objectMapper;
		StringTokenizer tokenizer;
		Object objeto;
		String clase;
		String json;
		
		log.debug("getAsObject");
		log.debug("context: {}", context);
		log.debug("component: {}", component);
		log.debug("value: {}", value);
		
		cadena = value.replaceAll("&c;", "\"").replaceAll("&amp;c;", "\"");
		
		//logger.debug("cadena: {}", cadena);
		
		objectMapper = new ObjectMapper();
		//logger.debug("objectMapper generado: {}", objectMapper);
		tokenizer = new StringTokenizer(cadena, "@", true);
		//logger.debug("Tokenizer creado: {} con tokens: {}", tokenizer, tokenizer.countTokens());
		
		if(tokenizer.countTokens() >= 2){
			clase = tokenizer.nextToken();
			tokenizer.nextToken(); //Descartar la @
			json = tokenizer.nextToken("");
			//logger.debug("tokens leidos. clase: {} json: {}", clase, json);
		} else {
			clase = null;
			json = null;
		}
		
		objeto = null;
		
		try {
			objeto = objectMapper.readValue(json, Class.forName(clase));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//logger.debug("getAsObject Objeto Generado: {}", objeto);		
		return objeto;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		StringBuilder stringBuilder;
		ObjectMapper objectMapper;
		String respuesta;
		
		log.debug("getAsString");
		log.debug("context: {}", context);
		log.debug("component: {}", component);
		log.debug("value: {}", value);
		log.debug("value class: {}", value.getClass().getName());
		
		objectMapper = new ObjectMapper();
		//objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		stringBuilder = new StringBuilder(value.getClass().getName());
		stringBuilder.append("@");
		try {
			stringBuilder.append(objectMapper.writeValueAsString(value));
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		
		respuesta = stringBuilder.toString().replaceAll("\"", "&c;");
		
		//logger.debug("getAsString Respuesta Generada: {}", respuesta);	
		return respuesta;
	}
	
}
