package com.saganet.school.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vc")
public class TestViewController {
	
	@RequestMapping("/view")
	public String vista(@RequestParam(name = "name", required = true, defaultValue = "World") String name, Model model) {
		
		model.addAttribute("nombre", name);
		
		return "view";
	}
}

