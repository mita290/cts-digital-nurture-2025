package com.example.jdbc_demo;

public class JdbcInsertUpdateExample {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        dao.insertStudent("Hulk", 81);
        dao.insertStudent("Phoenix", 89);
        dao.insertStudent("Wolverine", 86);
        dao.insertStudent("Storm", 83);

        dao.updateStudentGrade("Hulk", 85);
        dao.updateStudentGrade("Storm", 90);
    }
}