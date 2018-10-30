package com.saganet.school.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EncrytedPasswordUtils {
	 // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
 
	public static void main(String[] args) {
		String password = "123";
		String encrytedPassword = encrytePassword(password);

		log.info("Encryted Password: " + encrytedPassword);
	}
}
