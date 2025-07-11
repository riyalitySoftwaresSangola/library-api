package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LibrarianDTO {
	
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
    private String dateOfBirth;

	
}
