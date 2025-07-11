package com.library.serviceimplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.library.Entity.UserEntity;
import com.library.ServiceLiare.UserServiceInterface;
import com.library.dao.UserRepository;
import com.library.mapper.MapperClass;
import com.library.model.SignupValidationResponseDto;
import com.library.model.UserDto;
import com.library.model.UserLoginDto;
import com.library.model.UserResponceDto;

@Service

public class UserServiceImplementation implements UserServiceInterface {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MapperClass mapper;

	@Override
	public SignupValidationResponseDto sigunup(UserDto dto) {
		
		if (userRepository.existsByUsername(dto.getUsername())) {
            return new SignupValidationResponseDto(false, "❌ Username already taken. Try another.");
        }

        if ((dto.getRole().equalsIgnoreCase("admin") || dto.getRole().equalsIgnoreCase("librarian")) 
            && userRepository.existsByRole(dto.getRole())) {
            return new SignupValidationResponseDto(false, "❌ " + dto.getRole() + " already exists. You can't register another.");
        }


		UserEntity user = mapper.ToENtity(dto);
		System.out.println(user.getEmail());

		userRepository.save(user);

		System.out.println("Save is called");

		 return new SignupValidationResponseDto(true, "✅ Signup successful!");
	}



	@Override
	public UserResponceDto login(UserLoginDto userLoginDto) {
		Optional<UserResponceDto> data = userRepository.findRoleByUsernameAndPassword(userLoginDto.getUsername(),userLoginDto.getPassword());
		
		
		return data.orElse(null);
	}



	@Override
	public boolean findByUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}



	

}
