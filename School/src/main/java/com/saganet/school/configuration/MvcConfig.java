package com.saganet.school.configuration;

import javax.faces.webapp.FacesServlet;
import javax.servlet.Servlet;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ImportResource({"classpath:/META-INF/servlet-config.xml"})
public class MvcConfig {
	
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}
	
	@Bean
	public DispatcherServletRegistrationBean dispatcherServletRegistration() {
		DispatcherServletRegistrationBean dispatcherServletRB = new DispatcherServletRegistrationBean(dispatcherServlet(), "/app/*");
		dispatcherServletRB.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME);
		return dispatcherServletRB;
	}
	
//	@Bean
	public ServletRegistrationBean<Servlet> facesServlet() {
		ServletRegistrationBean<Servlet> register = new ServletRegistrationBean<Servlet>(new FacesServlet(), "*.faces");
		register.setLoadOnStartup(1);
		return register;
	}
	
}
