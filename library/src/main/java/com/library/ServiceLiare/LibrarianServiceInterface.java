package com.library.ServiceLiare;

import java.util.List;

import com.library.model.LibrarianDTO;
import com.library.model.LibrarianResponseDTO;

public interface LibrarianServiceInterface {

	LibrarianDTO addLibrarian(LibrarianDTO librarian);

	LibrarianResponseDTO getAllLibrarians();

	LibrarianDTO updateLibrarian(int id, LibrarianDTO librarianDTO);

	

	void deleteLibrarian(Integer id);

}
