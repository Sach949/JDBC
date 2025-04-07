package com.xworkz.books.runner;

import com.xworkz.books.dto.BookInfo;
import com.xworkz.books.service.BookService;
import com.xworkz.books.service.BookServiceImpl;

public class BookRunner {
    public static void main(String[] args) {


        BookInfo updateInfo = new BookInfo();

        updateInfo.setBookName("Mathematics");
        updateInfo.setAuthor("RP Sharma");
        updateInfo.setPublisherName("ABCD");
        updateInfo.setLanguage("Hindi");
        updateInfo.setGenre("Science");
        updateInfo.setPrice(250);

        BookInfo book = new BookInfo();


        BookService service = new BookServiceImpl();
        //service.saveBook(book);

//        String updateData = service.updateBook("Varshitha", "Varsha publications", "Kannada", 750, 2);
       // System.out.println(service);
       // System.out.println(updateData);
        service.getAllData();
        service.searchByPublishername("Varsha publications");
        service.deleteBooks(3);
        service.getAllData();
    }
}
