package com.xworkz.employee;

import java.sql.*;

public class DeleteEmployee {

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

//        String query = "UPDATE employee set designation = 'Clerk', idCard = 'ASD12345', dob = '2000-03-15',\n" +
//                "dateOfJoining = '2024-02-15', mobile = 1236541598, emailId = 'sunil@gmail.com',\n" +
//                "address1 = 'Jaipur' where empId = 102";

        //2nd way of updating dynamically
        String query = "Delete from employee where empId = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement =  conn.prepareStatement(query);
            statement.setInt(1, 103);
            statement.executeUpdate();
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
