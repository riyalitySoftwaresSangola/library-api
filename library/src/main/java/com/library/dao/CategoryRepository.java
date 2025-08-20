package com.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.Entity.Book_Category;

public interface CategoryRepository extends JpaRepository<Book_Category, Long> {

}
