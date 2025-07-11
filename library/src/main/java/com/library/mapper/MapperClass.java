package com.library.mapper;

import org.springframework.stereotype.Component;

import com.library.Entity.UserEntity;
import com.library.model.UserDto;

@Component
public class MapperClass {

	public UserDto ToDto(UserEntity userEntity) {
		
		
	UserDto dto = new UserDto(userEntity.getUsername(),userEntity.getEmail(),userEntity.getPhone_number(),userEntity.getPasswoard(),userEntity.getRole());
	
	        dto.setUsername(userEntity.getUsername());
	        dto.setEmail(userEntity.getEmail());
	        dto.setPhone_number(userEntity.getPhone_number());
	        dto.setPasswoard(userEntity.getPasswoard());
	        dto.setRole(userEntity.getRole());
	        
	        return dto;
		
	
		
	}
	
	public UserEntity ToENtity(UserDto dto) {
		
		UserEntity user = new UserEntity();
		
		user.setUsername(dto.getUsername());
		user.setEmail(dto.getEmail());
		user.setPhone_number(dto.getPhone_number());
		user.setPasswoard(dto.getPasswoard());
		user.setRole(dto.getRole());
		
		return user;
		
	}
	
}


