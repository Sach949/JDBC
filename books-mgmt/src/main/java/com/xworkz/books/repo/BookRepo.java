package com.xworkz.books.repo;

import com.xworkz.books.dto.BookInfo;

public interface BookRepo {

    String saveBook(BookInfo dto);

    boolean updateBook(String author, String publish, String lang, double price, int id);

    void readAll();

    String searchByPublishername(String publisher);

    String deleteBooks(int id);
}
