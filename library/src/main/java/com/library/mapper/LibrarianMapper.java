package com.library.mapper;

import com.library.Entity.LibrarianEntity;
import com.library.model.LibrarianDTO;
import com.library.model.LibrarianResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibrarianMapper {

    @Autowired
    private ModelMapper modelMapper;

    public LibrarianDTO toDto(LibrarianEntity entity) {
        if (entity == null) return null;
        return modelMapper.map(entity, LibrarianDTO.class);
    }

    public LibrarianEntity toEntity(LibrarianDTO dto) {
        if (dto == null) return null;
        return modelMapper.map(dto, LibrarianEntity.class);
    }

    // ✅ Fix: Convert Entity to ResponseDTO
    public LibrarianResponseDTO toResponseDto(LibrarianEntity entity) {
        if (entity == null) return null;
        return modelMapper.map(entity, LibrarianResponseDTO.class);
    }

	public LibrarianEntity toEntity(LibrarianResponseDTO librarianDTO) {
		 if (librarianDTO == null) return null;
	        return modelMapper.map(librarianDTO, LibrarianEntity.class);
		
	}
}
