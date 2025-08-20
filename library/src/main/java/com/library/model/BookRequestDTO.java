package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
 @Data

public class BookRequestDTO {
	  private String title;
	    private String author;
	    private String isbn;
	    private String edition;
	    private String publisher;
	    private double price;
	    private int copies;
	    private String categoryName;  // 🟡 Will be used to get or create category
}
