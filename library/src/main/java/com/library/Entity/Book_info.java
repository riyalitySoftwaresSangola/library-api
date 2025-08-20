package com.library.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_info")
public class Book_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    @Column(nullable = false)
    private String isbn;

    private String edition;
    private String publisher;
    private double price;
    private int copies;

    private String status = "available"; 
    private boolean isActive = true;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Book_Category category; // ✅ Use correct type with PascalCase
}
