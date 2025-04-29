package com.xworkz.books.service;

import com.xworkz.books.dto.BookInfo;
import com.xworkz.books.repo.BookRepo;
import com.xworkz.books.repo.BookRepoImpl;

public class BookServiceImpl implements BookService{

    BookRepo repo = new BookRepoImpl();
    @Override
    public String saveBook(BookInfo dto) {
        if(dto != null){
            return this.repo.saveBook(dto);
        }
        return "dta not inserted";
    }

    @Override
    public String updateBook(String author, String publish, String lang, double price, int id) {
        boolean isUpdated = repo.updateBook(author, publish,lang,price,id);
        if(isUpdated == true){
            return "Data updated";
        }
        return "Not Updated";
    }


}
