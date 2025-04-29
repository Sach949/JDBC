package com.xworkz.socialmedia;

import java.sql.*;

public class ReadSocialmedia {

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
        String query = "select * from users where user_id = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement =  conn.prepareStatement(query);
            statement.setInt(1, 2);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                System.out.println("Id is: "+resultSet.getInt("user_id"));
                System.out.println("Username is: "+resultSet.getString("username"));
                System.out.println("Email is: "+resultSet.getString("email"));
                System.out.println("Password is: "+resultSet.getString("password"));
                System.out.println("Date of creation is: "+resultSet.getDate("created_at"));
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
