package com.xworkz.vehicleapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertVehicle {

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


//        String query ="insert into vehicles values (1, 'Ravi Kumar', 'KA01AB1234', 'Car', '2022-05-10', 'Active')";
//        String query = " insert into vehicles values (2, 'Anita Sharma', 'DL05XY5678', 'Bike', '2021-08-15', 'Inactive')";
         String query = "insert into vehicles values (3, 'Vikram Patel', 'MH12CD7890', 'Truck', '2023-02-20', 'Und_Maint')";

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
