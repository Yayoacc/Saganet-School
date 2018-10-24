package com.saganet.school.database.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.saganet.school.database.entities.mdm.PadreEO;
import com.saganet.school.utils.Correo;

@Service("MailService")
public class MailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public Correo nuevo() {
		System.out.println("cree nuevo correo");
		return new Correo();
	}
	
//	String from, String to, String subject, String body
	public void sendMail(Correo correo) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(correo.getFrom());
        mail.setTo(correo.getTo());
        mail.setSubject(correo.getSubject());
        mail.setText(correo.getBody());

        javaMailSender.send(mail);
    }
	
	public void sendMail(List<PadreEO> padres, Correo correo) {
		for (PadreEO padre : padres) {
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setFrom("darcap1996@gmail.com");
	        mail.setTo(padre.getCorreoElectronico());
	        mail.setSubject(correo.getSubject());
	        mail.setText(correo.getBody());

	        javaMailSender.send(mail);
		}
    }
}
