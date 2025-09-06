package com.library.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.library.model.BookResponceDto;

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
    public BookRequestDTO saveBook(BookRequestDTO bookRequest) {

        // Step 1: Check if category exists by name
        Book_Category category = bookCategoryRepository.findByCategoryName(bookRequest.getCategoryName());

        // Step 2: If not exists, create new and save it
        if (category == null) {
            category = new Book_Category();
            category.setCategoryName(bookRequest.getCategoryName());
            category = bookCategoryRepository.save(category);
        }
        
        // Step 3: Check if book already exists with same details (title, author, edition, isbn, publisher, category)
        Optional<Book_info> existingBook = bookRepository.findByTitleAndAuthorAndEditionAndIsbnAndPublisherAndCategory(
                bookRequest.getTitle(),
                bookRequest.getAuthor(),
                bookRequest.getEdition(),
                bookRequest.getIsbn(),
                bookRequest.getPublisher(),
                category
        );

        if (existingBook.isPresent()) {
            // Step 4a: Book exists → update copies
            Book_info book = existingBook.get();
            book.setCopies(book.getCopies() + bookRequest.getCopies());
            bookRepository.save(book);
        } else {
            // Step 4b: Book does not exist → insert new
            Book_info book = bookMapper.toEntityWithCategory(bookRequest, category);
            bookRepository.save(book);
        }
		return bookRequest;
    }

	@Override
	public List getAllBooks() {
		
		List<Book_info> list = bookRepository.findAll();
		List<BookResponceDto> list1 = new ArrayList<>();
		
		for(Book_info book: list) {
			BookResponceDto data = bookMapper.toResponceDto(book);
			list1.add(data);
		}
		return list1;
		
	}

	@Override
	public BookResponceDto getBookByID(Long id) {
		Optional<Book_info> bookId = bookRepository.findById(id);
		if(!bookId.isPresent()) {
			throw new RuntimeException("the id is not found");
		}
		
		Book_info book = bookId.get();
		
  		return bookMapper.toResponceDto(book);
	}
}
