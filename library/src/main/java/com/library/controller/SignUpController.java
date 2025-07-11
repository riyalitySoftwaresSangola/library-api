package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.ServiceLiare.UserServiceInterface;
import com.library.model.SignupValidationResponseDto;
import com.library.model.UserDto;
import com.library.serviceimplementation.UserServiceImplementation;

@RestController
@RequestMapping("/SignUpController")
@CrossOrigin(origins = "*")

public class SignUpController {
	
	@Autowired
	private UserServiceInterface  userServiceInterface;

	@PostMapping("/sigunup")
	public ResponseEntity<SignupValidationResponseDto> signup(@RequestBody UserDto userDto) {

	    // ✅ Call the service to check and save
	    SignupValidationResponseDto response = userServiceInterface.sigunup(userDto);

	    // ✅ Return response with proper HTTP status if needed
	    if (!response.isSuccess()) {
	        // send 200 OK with error message (used in alert box)
	        return ResponseEntity.ok(response);
	    }

	    // ✅ Successful signup
	    return ResponseEntity.ok(response);
	}


	 @GetMapping("/check-username")
	 public boolean checkUsername(@RequestParam String username) {
	        return userServiceInterface.findByUsername(username);
	    } 
}
