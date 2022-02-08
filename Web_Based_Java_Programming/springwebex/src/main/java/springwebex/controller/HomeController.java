package springwebex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// ctrl+shift+t
@Controller // Indicates that an annotated class is a "Controller" (e.g. a web controller).
			// This annotation serves as a specialization of @Component,allowing for
			// implementation classes to be autodetected through classpath scanning.It is
			// typically used in combination with annotated handler methods based on the
			// org.springframework.web.bind.annotation.RequestMapping annotation.

public class HomeController {
	@RequestMapping("/home") // Annotation for mapping web requests onto methods in request-handling
								// classes with flexible method signatures.
	public String home() {
		System.out.println("Welcome to home page of spring mvc demo");
		return "home";
	}

	@RequestMapping("/contactus")
	public String contactUs(Model m) {
		System.out.println("Welcome to contact us page");
		m.addAttribute("address", "Bailey Road Patna");
		m.addAttribute("mobile", "7596885401");
		m.addAttribute("email", "faraz@gmail.com");
		return "contact";
	}
}
