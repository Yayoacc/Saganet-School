package com.saganet.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vc")
public class PerfilController {
	@RequestMapping("/perfil")
	public String vista(String name, Model model) {
		
		return "perfil";
	}
}
