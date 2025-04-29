package com.xworkz.foodapp;

import java.sql.*;

public class ReadOrder {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/admin";
        String user = "root";
        String pass = "Gtre@123";

        Connection conn = null;
        Statement st = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;


        //Reading the data
        String query = "select * from orders where order_id = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement =  conn.prepareStatement(query);
            statement.setInt(1, 2);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                System.out.println("Id is: "+resultSet.getInt("order_id"));
                System.out.println("Username is: "+resultSet.getString("customer_name"));
                System.out.println("Email is: "+resultSet.getString("food_item"));
                System.out.println("Password is: "+resultSet.getInt("quantity"));
                System.out.println("Date of creation is: "+resultSet.getDouble("total_price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
