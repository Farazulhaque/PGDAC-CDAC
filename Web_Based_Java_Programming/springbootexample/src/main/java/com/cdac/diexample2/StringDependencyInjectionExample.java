package com.cdac.diexample2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StringDependencyInjectionExample {

	public static void main(String[] args) {
//		SpringApplication.run(StringDependencyInjectionExample.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cdac.diexample2");
		context.refresh();

//		User u = (User) context.getBean("gamer");
		User u = (User) context.getBean("gamercomponent");

		u.doWork();
	}
}
