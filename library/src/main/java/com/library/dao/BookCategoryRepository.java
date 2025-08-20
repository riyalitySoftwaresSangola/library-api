package com.library.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.Entity.Book_Category;
import com.library.Entity.Book_info;

import java.util.Optional;

public interface BookCategoryRepository extends JpaRepository<Book_Category, Integer> {



	Book_Category save(Book_Category category);

	

	Book_Category findByCategoryName(String categoryName);
   
	


	
}