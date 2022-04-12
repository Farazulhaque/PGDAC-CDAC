package com.medibox.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.medibox.admin")
public class PharmacyAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyAdminApplication.class, args);
	}

}
