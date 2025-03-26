package com.xworkz.employee;

import java.sql.*;

public class InsertEmployees {
    public static void main(String[] args) {

        //2. loading and registering driver class.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        //3. create connection with database
        String url =  "jdbc:mysql://localhost:3306/admin";
        String userName = "root";
        String password = "Gtre@123";


        //4. create statement
        Connection connection= null;
        Statement stmt = null;

        //5. Creating query and execute statement
        String query = "insert into employee values(103,'Ajay', 'Store/A','DFG65432', '2001-04-11', '2023-12-15','Rajkot'," +
                " 'Delhi', 8974563210,'ajay@gmail.com','B.Com','2025-06-12 10:00:00','2025-06-12 10:00:00', '2025-06-12')";
        try {
           connection =  DriverManager.getConnection(url, userName, password);
           stmt = connection.createStatement();
           stmt.execute(query);
            System.out.println("inserted data is: "+stmt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            //6. closing the costly resources
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
