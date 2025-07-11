package com.library.ServiceLiare;


import com.library.model.SignupValidationResponseDto;
import com.library.model.UserDto;
import com.library.model.UserLoginDto;
import com.library.model.UserResponceDto;

public interface UserServiceInterface {

	SignupValidationResponseDto sigunup(UserDto userDto);

	UserResponceDto login (UserLoginDto userLoginDto);

	boolean findByUsername(String username);
	}


