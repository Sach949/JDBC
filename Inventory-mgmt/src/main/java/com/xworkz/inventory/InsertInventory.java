package com.xworkz.inventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertInventory {

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


//        String query ="insert into inventory values (1, 'Laptop', 10, 55000.00, 'Tech Suppliers Pvt Ltd', '2024-03-25')";
//        String query = "insert into inventory values (2, 'Office Chair', 20, 4500.00, 'Furniture World', '2024-03-26')";
        String query = "insert into inventory values (3, 'Printer', 5, 12000.00, 'IT Solutions Ltd', '2024-03-27')";

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
