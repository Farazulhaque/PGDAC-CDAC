package com.cdac.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.project.model.UserSignup;
import com.cdac.project.repository.UserSignupRepository;

@Controller
public class MyController {

	@Autowired
	private UserSignupRepository userSignupRepository;

	@RequestMapping("/")
	public String index() {
		System.out.println("Index page called");
		return "index";
	}

	@RequestMapping("/UserSignup")
	public String userSignup() {
		System.out.println("UserSignup page called");
		return "UserSignup";
	}

	@RequestMapping("/UserLogin")
	public String userLogin() {
		System.out.println("UserLogin page called");
		return "UserLogin";
	}

	@PostMapping("/process_userSignup")
	public String ProcessUserSignup(UserSignup user) {
		System.out.println("process_userSignup called");
		userSignupRepository.save(user);
		System.out.println(user.toString());
		return "index";
	}
}
