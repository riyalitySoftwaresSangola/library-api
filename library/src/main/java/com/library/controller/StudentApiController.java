package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.ServiceLiare.StudentServiceApiInterface;
import com.library.model.StudentInfoDto;
import com.library.model.StudentResponceDto;

@RestController
@RequestMapping("/Student")
@CrossOrigin(origins = "*")
public class StudentApiController {

	@Autowired
	private StudentServiceApiInterface studentServiceApiInterface;

	@PostMapping("/AddStudent")
	public StudentInfoDto addStudent(@RequestBody StudentInfoDto studentInfoDto) {

		return studentServiceApiInterface.addStudent(studentInfoDto);

	}
	@GetMapping("/getAllStudent")
	public List<StudentResponceDto> getAllStudent() {
		
	return studentServiceApiInterface.findByIsActiveTrue();
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<StudentResponceDto> getStudentById(@PathVariable int id) {
	    StudentResponceDto dto = studentServiceApiInterface.getStudentById(id);
	    return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<StudentResponceDto> updateStudent(@RequestBody StudentResponceDto dto) {
		StudentResponceDto updated = studentServiceApiInterface.updateStudent(dto);
	    return ResponseEntity.ok(updated);
	}
	
	 @PostMapping("/softDelete/{id}")
	    public String softDelete(@PathVariable int id) {
	        boolean deleted = studentServiceApiInterface.softDeleteById(id);
	        if (deleted) {
	            return "Student marked as inactive successfully.";
	        } else {
	            return "Student not found or already inactive.";
	        }
	    }


}
