package com.cdac.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootexampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootexampleApplication.class, args);
		Employee emp = context.getBean(Employee.class);
		emp.show();
		
		
		context.close();
	}

}
