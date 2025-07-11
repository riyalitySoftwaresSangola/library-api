package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.UserDto;
import com.library.model.UserLoginDto;
import com.library.model.UserResponceDto;
import com.library.serviceimplementation.UserServiceImplementation;

@RestController
@RequestMapping("/LoginController")
public class LoginController {
	
	@Autowired
	private UserServiceImplementation userserviceImplementation;

	@PostMapping("/addloginuser")
	public UserResponceDto addloginuser(@RequestBody UserLoginDto loginuser ) {
		
			return userserviceImplementation.login(loginuser);
	}
}
