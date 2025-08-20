package com.library.ServiceLiare;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.library.model.StudentInfoDto;
import com.library.model.StudentResponceDto;


public interface StudentServiceApiInterface {

	StudentInfoDto addStudent(StudentInfoDto studentInfoDto);

	List<StudentResponceDto> findByIsActiveTrue();

	StudentResponceDto getStudentById(int id);

	StudentResponceDto updateStudent(StudentResponceDto dto);

	boolean softDeleteById(int id);





}
