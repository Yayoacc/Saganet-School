package com.saganet.school.database.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.saganet.school.database.domains.AccionDO;
import com.saganet.school.database.domains.GeneroDO;
import com.saganet.school.utils.Modelo;

@Service("DominiosServ")
public class DominiosServ {
	
	public Modelo<GeneroDO> modeloGeneroDO(){
		return new Modelo<>(Arrays.asList(GeneroDO.values()));
	}
	public Modelo<AccionDO> modeloAccionDO(){
		return new Modelo<>(Arrays.asList(AccionDO.values()));
	}
}
