package com.library.ServiceLiare;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.model.BookRequestDTO;
import com.library.model.BookResponceDto;

@Service
public interface BookServiceInterface {

	
	BookRequestDTO saveBook(BookRequestDTO bookRequest);

	List<BookResponceDto> getAllBooks();

	BookResponceDto getBookByID(Long id);
	

	

}
