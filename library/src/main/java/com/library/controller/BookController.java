package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.library.ServiceLiare.BookServiceInterface;
import com.library.model.BookRequestDTO;

@RestController
@RequestMapping("/Book")
public class BookController {
	
	
	
	@Autowired
	private BookServiceInterface bookServiceInterface;
	
	
	
	
		 @PostMapping("/AddBook")
		 public ResponseEntity<String> addBook(@RequestBody BookRequestDTO bookRequest) {
			 bookServiceInterface.saveBook(bookRequest);
			 return (ResponseEntity<String>) ResponseEntity.ok();
		 }
		    }


