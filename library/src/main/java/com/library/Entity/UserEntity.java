package com.library.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_info")
public class UserEntity {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
    @Column(unique = true)
	private String username;
	private String Email;
	private int phone_number;
	private String passwoard ;
	private String role;
	
	
	public UserEntity(String username, String email, int phone_number, String passwoard, String role) {
		super();
		this.username = username;
		this.Email = email;
		this.phone_number = phone_number;
		this.passwoard = passwoard;
		this.role = role;
	}
	
	
	

}
