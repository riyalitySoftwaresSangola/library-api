
package com.library.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.Entity.StudentEntity;
import com.library.ServiceLiare.StudentServiceApiInterface;
import com.library.dao.StudentRepositry;
import com.library.mapper.StudentMapper;
import com.library.model.StudentInfoDto;
import com.library.model.StudentResponceDto;
@Service
public class StudentServiceImplimention implements StudentServiceApiInterface {
@Autowired
private StudentRepositry studentRepositry;

@Autowired
private StudentMapper studentMapper;



	@Override
	public StudentInfoDto addStudent(StudentInfoDto studentInfoDto) {
		
	StudentEntity student =	 studentMapper.toEntity(studentInfoDto);
	StudentEntity Std = studentRepositry.save(student);
		StudentInfoDto dto = studentMapper.todto(Std);
		
		return dto;
	}
	@Override
	public List<StudentResponceDto> findByIsActiveTrue() {
		List<StudentEntity> list = studentRepositry.findByIsActiveTrue();
		List<StudentResponceDto> list1 = new ArrayList<>();
		for (StudentEntity Student : list) {
			StudentResponceDto data =studentMapper.toResponceDto(Student);
			list1.add(data);
		}
		return list1;
	}
	@Override
	public StudentResponceDto getStudentById(int id) {
	    Optional<StudentEntity> optional = studentRepositry.findById(id);
	    if (!optional.isPresent()) {	
	        throw new RuntimeException("Student not found with ID: " + id);
	    }

	    StudentEntity student = optional.get();
	    return studentMapper.toResponceDto(student);  // Convert Entity → DTO
	

	}       



	@Override
    public StudentResponceDto updateStudent(StudentResponceDto dto) {
        // Step 1: Fetch existing student by ID
        Optional<StudentEntity> optional = studentRepositry.findById(dto.getId());

        if (!optional.isPresent()) {
            throw new RuntimeException("Student not found with ID: " + dto.getId());
        }

        StudentEntity existingStudent = optional.get();

        // Step 2: Update only the fields from the DTO to entity
        StudentEntity updatedStudent = studentMapper.toEntity(dto);
        updatedStudent.setId(existingStudent.getId()); // Ensure ID is retained

        // Step 3: Save updated entity
        StudentEntity savedStudent = studentRepositry.save(updatedStudent);

        // Step 4: Convert to response DTO
        return studentMapper.toDto(savedStudent);
    }
	@Override
    public boolean softDeleteById(int id) {
        Optional<StudentEntity> optional = studentRepositry.findById(id);

        if (optional.isPresent()) {
            StudentEntity student = optional.get();

            if (!student.isActive()) {
                return false; // already inactive
            }

            student.setActive(false);  // <-- soft delete here
            studentRepositry.save(student);
            return true;
        }

        return false;
    }



	
	}


