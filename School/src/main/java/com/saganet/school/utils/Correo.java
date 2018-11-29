package com.saganet.school.utils;

import java.io.Serializable;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Correo implements Serializable {
	private String from = "dualmodelitp@gmail.com";
	private String to;
	private String subject;
	private String body;
}
