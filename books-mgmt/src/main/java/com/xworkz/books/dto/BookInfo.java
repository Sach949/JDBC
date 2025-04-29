package com.xworkz.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookInfo {

    private int bookId;
    private String bookName;
    private String author;
    private  String publisherName;
    private String language;
    private String genre;
    private double price;



    
}
