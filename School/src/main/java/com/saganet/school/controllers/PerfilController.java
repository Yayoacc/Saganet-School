package com.saganet.school.controllers;

import java.security.Principal;

import org.primefaces.component.log.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saganet.school.utils.WebUtils;

import lombok.extern.slf4j.Slf4j;
@Slf4j

@Controller
public class PerfilController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model) {
		return "login";
	}
	
	@RequestMapping(value = "error/403", method = RequestMethod.GET)
	public String AccessDenied(Model model) {
		return "403";
	}
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public String perfil( Model model, Principal principal) {
		String userName = principal.getName();
		 
       log.info("User Name: " + userName);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        log.info("Información del Usuario: "+ userInfo);
		return "perfil";
	}
} 	 