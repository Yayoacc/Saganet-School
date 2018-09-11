package com.saganet.school.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rc")
public class TestRestController {
	
	@RequestMapping("/rest")
    public String mensaje() {
        return "Mensaje directo desde Controlador REST!";
    }
}
