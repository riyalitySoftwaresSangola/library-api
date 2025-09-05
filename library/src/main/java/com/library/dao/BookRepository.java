package com.library.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.Entity.Book_Category;
import com.library.Entity.Book_info;



public interface BookRepository extends JpaRepository<Book_info, Long> {

	Optional<Book_info> findByTitleAndAuthorAndEditionAndIsbnAndPublisherAndCategory(String title, String author,
			String edition, String isbn, String publisher, Book_Category category);

	

}
