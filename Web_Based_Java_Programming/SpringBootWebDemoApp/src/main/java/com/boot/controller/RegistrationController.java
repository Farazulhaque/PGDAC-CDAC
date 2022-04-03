package com.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.entity.Users;
import com.boot.service.UserService;

/**
 * Controls registration requests
 * 
 * @author admin
 *
 */
@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String getRegistrationPage(Model model) {
		Users user = new Users();
		model.addAttribute("newUser", user);
		return "registration";
	}

	@PostMapping("/registration")
	public String registerUser(@ModelAttribute("newUser") @Valid Users user, BindingResult result,
			HttpServletRequest request, Model model) {
		if (result.hasErrors()) {
			return "registration";
		}
		Users existingUser = userService.findByEmail(user.getEmail());
		if (existingUser != null) {
			model.addAttribute("loginError", true);
			return "registration";
		}
		HttpSession session = request.getSession();
		{
			userService.save(user);
			session.setAttribute("currentUser", user);
			return "redirect:/home";
		}
	}
}
