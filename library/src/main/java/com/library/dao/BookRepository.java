package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.Entity.Book_info;



public interface BookRepository extends JpaRepository<Book_info, Long> {

	

}
