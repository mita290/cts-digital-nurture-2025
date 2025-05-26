package com.example.jdbc_demo;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/school";
        String user = "postgres";
        String password = "11250816msk";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
            return;
        }

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Grade: " + rs.getInt("grade"));
            }

        } catch (SQLException e) {
            System.out.println("Database error!");
            e.printStackTrace();
        }
    }
}
