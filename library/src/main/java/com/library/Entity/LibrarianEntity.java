package com.library.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="librarian_info")
public class LibrarianEntity {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
    private String email;
    private String phoneNumber;
    private String password;
    private String role;

    // Additional personal and professional details (as discussed earlier)
    private String fullName;
    private String education;
    private String qualification;
    private String experience;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private LocalDate dateOfBirth;
	
	
	
	

}
