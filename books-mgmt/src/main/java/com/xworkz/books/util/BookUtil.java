package com.xworkz.books.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BookUtil {

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/admin", "root", "Gtre@123");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
