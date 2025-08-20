package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponceDto {
	private int id;
	 private String username;
	    private String email;
	    private String phoneNumber;
	    private String password;
	    private String role;

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
	    private String gender;
	    private String aadhar;
	    private String university;
	    private String yearOfPassing;

	    private String bankAccount;
	    private String ifsc;
	    private String pan;
	    private String salary;
	    private String paymentMode;

}
