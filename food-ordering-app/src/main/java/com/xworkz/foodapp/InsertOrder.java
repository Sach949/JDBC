package com.xworkz.foodapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertOrder {

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

        String query ="insert into orders values (3, 'Amit Patel', 'Masala Dosa', 3, 210.00)";
//        String query = "insert into orders values (2, 'Priya Verma', 'Chicken Biryani', 1, 300.00)";
      // String query = "insert into orders values (1, 'Rajesh Sharma', 'Paneer Butter Masala', 2, 450.00)";

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
