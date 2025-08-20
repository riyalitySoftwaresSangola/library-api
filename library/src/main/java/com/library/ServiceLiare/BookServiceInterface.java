package com.library.ServiceLiare;

import org.springframework.stereotype.Service;

import com.library.model.BookRequestDTO;

@Service
public interface BookServiceInterface {

	
	void saveBook(BookRequestDTO bookRequest);
	

	

}
