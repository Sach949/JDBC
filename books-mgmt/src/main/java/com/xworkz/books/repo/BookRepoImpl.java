package com.xworkz.books.repo;

import com.xworkz.books.dto.BookInfo;
import com.xworkz.books.util.BookUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepoImpl implements BookRepo {

    @Override
    public String saveBook(BookInfo dto) {
        Connection connection = BookUtil.getConnection();
        PreparedStatement prpStmt = null;
        String query = "insert into book_info(bookName,author,publisherName,language,genre,price) values(?,?,?,?,?,?)";

        try {
            prpStmt = connection.prepareStatement(query);
            prpStmt.setString(1, dto.getBookName());
            prpStmt.setString(2, dto.getAuthor());
            prpStmt.setString(3, dto.getPublisherName());
            prpStmt.setString(4, dto.getLanguage());
            prpStmt.setString(5, dto.getGenre());
            prpStmt.setDouble(6, dto.getPrice());
            prpStmt.executeUpdate();
            System.out.println("Data inserted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (prpStmt != null) {
                try {
                    prpStmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return "Data not saved";
    }

    @Override
    public boolean updateBook(String author, String publish, String lang, double price, int id) {
        Connection connection = BookUtil.getConnection();
        String query = "update book_info set author = ?, publisherName =?, language =?, price = ? where bookId = ?";
        PreparedStatement prpStmt = null;
        int check = 0;
        try {
            prpStmt = connection.prepareStatement(query);
            prpStmt.setString(1, author);
            prpStmt.setString(2, publish);
            prpStmt.setString(3, lang);
            prpStmt.setDouble(4, price);
            prpStmt.setInt(5, id);
            check = prpStmt.executeUpdate();
            if (check >= 1) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (prpStmt != null) {
                try {
                    prpStmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return false;
        }

    }

    @Override
    public void readAll() {
        Connection connection = BookUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("select * from book_info");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                System.out.println("Id is: "+resultSet.getInt("bookId"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



