package com.example.jdbc_demo;

import java.sql.*;

public class StudentDAO {
    private final String url = "jdbc:postgresql://localhost:5432/school";
    private final String user = "postgres"; 
    private final String password = "11250816msk"; 

    public void insertStudent(String name, int grade) {
        String query = "INSERT INTO students (name, grade) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setInt(2, grade);
            pstmt.executeUpdate();
            System.out.println(name + " inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        }
    }

    public void updateStudentGrade(String name, int newGrade) {
        String query = "UPDATE students SET grade = ? WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, newGrade);
            pstmt.setString(2, name);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println(name + "'s grade updated to " + newGrade);
            } else {
                System.out.println("No student found with name: " + name);
            }

        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        }
    }
}
