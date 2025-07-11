package com.library.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.library.Entity.LibrarianEntity;
import com.library.ServiceLiare.LibrarianServiceInterface;
import com.library.dao.LibrarianRepository;
import com.library.mapper.LibrarianMapper;
import com.library.model.LibrarianDTO;
import com.library.model.LibrarianResponseDTO;


@Service
public class LibrarianServiceImpl implements LibrarianServiceInterface {
	
	@Autowired
	private LibrarianRepository librarianRepository;
	
	@Autowired
	private LibrarianMapper librarianMapper;

	@Override
	public LibrarianDTO addLibrarian(LibrarianDTO librarian) {
		
		 System.out.println("Checking Email in DTO: " + librarian.getEmail()); // ✅ Print to console/log
		LibrarianEntity liberary = librarianMapper.toEntity(librarian);
		LibrarianEntity liberyee= librarianRepository.save(liberary);
		LibrarianDTO data = librarianMapper.toDto(liberyee);
		return data;
	}

	@Override
	public LibrarianResponseDTO getAllLibrarians() {
	    List<LibrarianEntity> librarians = (List<LibrarianEntity>) librarianRepository.findAll();
		 if (!librarians.isEmpty()) {
		        LibrarianEntity librarian = librarians.get(0); // ✅ Get the first record
		        return librarianMapper.toResponseDto(librarian);
		    }

		    return null; // or return new LibrarianResponseDTO();
		}

	@Override
	public LibrarianDTO updateLibrarian(int id, LibrarianDTO librarian) {
		
		System.out.println(librarian.getId());
		/*
		 * LibrarianEntity existingEntity = librarianRepository.findById(id)
		 * .orElseThrow(() -> new RuntimeException("Librarian not found with ID: " +
		 * id));
		 */
		
		Optional<LibrarianEntity> existingEntity	=librarianRepository.findById(id);
		System.out.println("librariyan:"+existingEntity);
	    LibrarianEntity updatedEntity = librarianMapper.toEntity(librarian);
	    updatedEntity.setId(id); // VERY IMPORTANT

	    LibrarianEntity savedEntity = librarianRepository.save(updatedEntity);
	    return librarianMapper.toDto(savedEntity);
	}

	@Override
	public void deleteLibrarian(Integer id) {
		
		  if (librarianRepository.existsById(id)) {
		        librarianRepository.deleteById(id);
		    } else {
		        throw new RuntimeException("Librarian not found with ID: " + id);
		    }
		
	}
	}

	
	


