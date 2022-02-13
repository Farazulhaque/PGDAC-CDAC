package com.cdac.mybootex;

import java.util.List;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.event.PublicInvocationEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
	@Autowired
	private UserRepository uRepository;

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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodeString = encoder.encode(user.getPassword());
		user.setPassword(encodeString);
		uRepository.save(user);
		return "register_success";
	}

	@GetMapping("/list_user")
	public String viewUserList(Model model) {
		List<User> uList = uRepository.findAll();
		model.addAttribute("userlist", uList);

		return "users";
	}
}
