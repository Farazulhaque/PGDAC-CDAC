package com.cdac.restex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.restex.model.User;
import com.cdac.restex.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	// build create user rest api
	@PostMapping()
	// @RequestBody allows us to retreive the request body and automattically
	// convert it to java object
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

}
