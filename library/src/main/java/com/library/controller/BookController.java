package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.ServiceLiare.BookServiceInterface;
import com.library.model.BookRequestDTO;
import com.library.model.BookResponceDto;

@RestController
@RequestMapping("/Book")
public class BookController {

	@Autowired
	private BookServiceInterface bookServiceInterface;

	@PostMapping("/AddBook")
	public ResponseEntity<BookRequestDTO> addBook(@RequestBody BookRequestDTO bookRequest) {
		BookRequestDTO response =	bookServiceInterface.saveBook(bookRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<BookResponceDto>> getAllBooks() {
		
		
		return ResponseEntity.ok(bookServiceInterface.getAllBooks());
		
		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<BookResponceDto> getById(@PathVariable Long id) {
		
		BookResponceDto book = bookServiceInterface.getBookByID(id);
		
		
		
		return ResponseEntity.ok(book);
	}
	
}
