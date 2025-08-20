package com.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.Entity.StudentEntity;

@Repository
public interface StudentRepositry extends JpaRepository<StudentEntity, Integer>  {

	List<StudentEntity> findByIsActiveTrue();

}
