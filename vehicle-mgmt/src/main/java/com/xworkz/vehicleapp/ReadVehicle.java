package com.xworkz.vehicleapp;

import java.sql.*;

public class ReadVehicle {

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
        String query = "select * from vehicles where vehicle_id = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement =  conn.prepareStatement(query);
            statement.setInt(1, 2);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                System.out.println("Id is: "+resultSet.getInt("vehicle_id"));
                System.out.println("Owner Name is: "+resultSet.getString("owner_name"));
                System.out.println("Vehicle number is: "+resultSet.getString("vehicle_number"));
                System.out.println("Vehicle type is: "+resultSet.getString("vehicle_type"));
                System.out.println("Registration date is: "+resultSet.getDate("registration_date"));
                System.out.println("Status is: "+resultSet.getString("status"));
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
