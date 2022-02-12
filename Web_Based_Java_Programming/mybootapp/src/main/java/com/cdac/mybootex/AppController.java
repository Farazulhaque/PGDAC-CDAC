package com.cdac.mybootex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	@Autowired
	private UserRepository uRepository;

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping("/home")
	public String home() {
		return "index";
	}

	@GetMapping("/register")
	public String showSignUp(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegistration(User user) {
		uRepository.save(user);
		return "register_success";
	}
}