package com.xworkz.inventory;

import java.sql.*;

public class ReadInventory {

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
        String query = "select * from inventory where item_id = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement =  conn.prepareStatement(query);
            statement.setInt(1, 1);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                System.out.println("Id is: "+resultSet.getInt("item_id"));
                System.out.println("Item Name is: "+resultSet.getString("item_name"));
                System.out.println("Qunatiy of item is: "+resultSet.getInt("quantity"));
                System.out.println("Price is: "+resultSet.getDouble("price"));
                System.out.println("Supplier name is: "+resultSet.getString("supplier"));
                System.out.println("Inventory Added date is: "+resultSet.getDate("added_on"));
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
