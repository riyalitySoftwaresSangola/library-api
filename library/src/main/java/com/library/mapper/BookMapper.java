package com.library.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.Entity.Book_info;
import com.library.Entity.Book_Category;
import com.library.model.BookRequestDTO;

@Component
public class BookMapper {

    @Autowired
    private ModelMapper modelMapper;

    // Simple mapping (category must be set manually in service)
    public Book_info toEntity(BookRequestDTO dto) {
        return modelMapper.map(dto, Book_info.class);
    }

    // DTO mapping
    public BookRequestDTO toDto(Book_info entity) {
        BookRequestDTO dto = modelMapper.map(entity, BookRequestDTO.class);

        // Add manual mapping for category name
        if (entity.getCategory() != null) {
            dto.setCategoryName(entity.getCategory().getCategoryName());
        }

        return dto;
    }

    // Custom mapping: DTO + Category object to Entity
    public Book_info toEntityWithCategory(BookRequestDTO dto, Book_Category category) {
        Book_info book = modelMapper.map(dto, Book_info.class);
        book.setCategory(category);
        return book;
    }
}
