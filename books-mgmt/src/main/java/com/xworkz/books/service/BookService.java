package com.xworkz.books.service;

import com.xworkz.books.dto.BookInfo;

public interface BookService {
    String saveBook(BookInfo dto);

    String updateBook(String author, String publish, String lang, double price, int id);
}
