package com.library.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.Entity.LibrarianEntity;
import com.library.Entity.StudentEntity;
import com.library.model.StudentInfoDto;
import com.library.model.StudentResponceDto;

@Component
public class StudentMapper {
	@Autowired
	private  ModelMapper modelMapper;
	
	public StudentInfoDto todto(StudentEntity std) {
		
		return modelMapper.map(std ,StudentInfoDto.class);
		
	}
	
	public StudentEntity toEntity(StudentInfoDto dto) {
		
		return modelMapper.map(dto, StudentEntity.class);
		
	}

	public StudentResponceDto toResponceDto(StudentEntity student) {
		
		return modelMapper.map(student, StudentResponceDto.class);
	}

	public StudentEntity toEntity(StudentResponceDto dto) {
		
		return modelMapper.map(dto, StudentEntity.class);
	}

	public StudentResponceDto toDto(StudentEntity savedStudent) {
		
		return modelMapper.map(savedStudent, StudentResponceDto.class);
	}


	
	
	

}
