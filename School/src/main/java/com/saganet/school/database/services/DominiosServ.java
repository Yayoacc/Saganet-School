package com.saganet.school.database.services;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.saganet.school.database.domains.GeneroDO;
import com.saganet.school.utils.Modelo;

@Service("DominiosServ")
public class DominiosServ {
	
	public Modelo<GeneroDO> modeloGeneroDO(){
		return new Modelo<>(Arrays.asList(GeneroDO.values()));
	}
}
