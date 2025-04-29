package com.xworkz.employee;

import java.sql.*;

public class ReadEmployee {

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
        String query = "select * from employee where empId = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            statement =  conn.prepareStatement(query);
            statement.setInt(1, 102);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                System.out.println("Id is: "+resultSet.getInt("empId"));
                System.out.println("Name is: "+resultSet.getString("name"));
                System.out.println("Designation is: "+resultSet.getString("designation"));
                System.out.println("Id Card is: "+resultSet.getString("idCard"));
                System.out.println("Dob is: "+resultSet.getDate("dob"));
                System.out.println("Date Of Joining is: "+resultSet.getDate("dateOfJoining"));
                System.out.println("address1 is: "+resultSet.getString("address1"));
                System.out.println("address2 is: "+resultSet.getString("address2"));
                System.out.println("mobile is: "+resultSet.getLong("mobile"));
                System.out.println("emailId is: "+resultSet.getString("emailId"));
                System.out.println("qualification is: "+resultSet.getString("qualification"));
                System.out.println("puchInTime is: "+resultSet.getTimestamp("puchInTime"));
                System.out.println("punchOutTime is: "+resultSet.getTimestamp("punchOutTime"));
                System.out.println("sysDate is: "+resultSet.getDate("sysDate"));
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
