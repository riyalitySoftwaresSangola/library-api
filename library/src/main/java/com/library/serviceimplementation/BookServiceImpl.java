package com.library.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.Entity.Book_Category;
import com.library.Entity.Book_info;
import com.library.ServiceLiare.BookServiceInterface;
import com.library.dao.BookCategoryRepository;
import com.library.dao.BookRepository;
import com.library.mapper.BookMapper;
import com.library.model.BookRequestDTO;

@Service
public class BookServiceImpl implements BookServiceInterface {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    @Transactional
    public void saveBook(BookRequestDTO bookRequest) {

        // Step 1: Check if category exists by name
        Book_Category category = bookCategoryRepository.findByCategoryName(bookRequest.getCategoryName());

        // Step 2: If not exists, create new and save it
        if (category == null) {
            category = new Book_Category();
            category.setCategoryName(bookRequest.getCategoryName());
            category = bookCategoryRepository.save(category);
        }

        // Step 3: Convert DTO to Entity and attach category
        Book_info book = bookMapper.toEntityWithCategory(bookRequest, category);

        // Step 4: Save book
        bookRepository.save(book);
    }
}
