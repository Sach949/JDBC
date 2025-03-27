package com.xworkz.socialmedia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertSocial {

    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        String url =  "jdbc:mysql://localhost:3306/admin";
        String userName = "root";
        String password = "Gtre@123";



        Connection connection= null;
        Statement stmt = null;


//        String query ="insert into users values (1, 'rahul123', 'rahul.sharma@example.com', 'Rahul@123', '2024-03-25')";
//        String query = " insert into users values (2, 'priya_verma', 'priya.verma@example.com', 'Priya@456', '2024-03-26')";
        String query = "insert into users values (3, 'amit_patel', 'amit.patel@example.com', 'Amit@789', '2024-03-27')";

        try {
            connection =  DriverManager.getConnection(url, userName, password);
            stmt = connection.createStatement();
            stmt.execute(query);
            System.out.println("inserted data is: "+stmt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
