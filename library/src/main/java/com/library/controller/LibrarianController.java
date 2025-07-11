package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.ServiceLiare.LibrarianServiceInterface;
import com.library.model.LibrarianDTO;
import com.library.model.LibrarianResponseDTO;

@RestController
@RequestMapping("/addlibririyan")
@CrossOrigin(origins = "*")
public class LibrarianController {
	@Autowired
	private LibrarianServiceInterface librarianServiceInterface;
	
	@PostMapping("/addlibririyan")
	public LibrarianDTO addLibrarian(@RequestBody LibrarianDTO librarian) {
		
		System.out.println("the api controller ="+librarian.getDateOfBirth());
		System.out.println("the api controller ="+librarian.getPhoneNumber());
		
		return librarianServiceInterface.addLibrarian(librarian);
		
	}
	@GetMapping("/getAllLibrarian")
    public LibrarianResponseDTO getLibrarianData() {
        return librarianServiceInterface.getAllLibrarians();
    }
	
	@PostMapping("/update/{id}")
	    public ResponseEntity<LibrarianDTO> updateLibrarian(@PathVariable  int id,@RequestBody LibrarianDTO librarianDTO) {
	    
		System.out.println("💡 Email from form api controller: " + librarianDTO.getEmail());
		
		LibrarianDTO updated = librarianServiceInterface.updateLibrarian(id, librarianDTO);
	        return ResponseEntity.ok(updated);
	    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLibrarian(@PathVariable int id) {
	    librarianServiceInterface.deleteLibrarian(id);
	    return ResponseEntity.ok("Librarian with ID " + id + " deleted successfully.");
	}

  
}