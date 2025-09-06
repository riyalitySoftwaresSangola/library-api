package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponceDto {
	private int id;
	 private String title;
	    private String author;
	    private String edition;
	    private String publisher;
	    private double price;
	    private int copies;
	    private String categoryName;
}
