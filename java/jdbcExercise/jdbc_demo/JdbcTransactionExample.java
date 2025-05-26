package com.example.jdbc_demo;

public class JdbcTransactionExample {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        dao.transferMoney("Tony Stark", "Steve Rogers", 200.00);
    }
}