package com.cdac.mybootex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	// @RequestMapping(method = RequestMethod.GET)
	@GetMapping("/home")
	public String home() {
		return "index";
	}

}