package com.cdac.mybootex;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawpasswordString = "1234";
		String enString = encoder.encode(rawpasswordString);
		System.out.println(enString);
	}

}
