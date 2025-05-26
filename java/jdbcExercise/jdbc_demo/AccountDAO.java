package com.example.jdbc_demo;

import java.sql.*;

public class AccountDAO {
    private final String url = "jdbc:postgresql://localhost:5432/school";
    private final String user = "postgres";
    private final String password = "11250816msk";

    public void transferMoney(String fromName, String toName, double amount) {
        String debitSql = "UPDATE accounts SET balance = balance - ? WHERE name = ?";
        String creditSql = "UPDATE accounts SET balance = balance + ? WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false); 

            try (PreparedStatement debitStmt = conn.prepareStatement(debitSql);
                 PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {

                debitStmt.setDouble(1, amount);
                debitStmt.setString(2, fromName);
                int debitRows = debitStmt.executeUpdate();

                creditStmt.setDouble(1, amount);
                creditStmt.setString(2, toName);
                int creditRows = creditStmt.executeUpdate();

                if (debitRows == 1 && creditRows == 1) {
                    conn.commit(); 
                    System.out.println("Transferred $" + amount + " from " + fromName + " to " + toName);
                } else {
                    conn.rollback(); 
                    System.out.println("Transfer failed. Transaction rolled back.");
                }

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction error. Rolled back.");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
