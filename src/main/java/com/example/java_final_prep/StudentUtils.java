package com.example.java_final_prep;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentUtils {
    private StudentUtils(){

    }
    public static void createTable() throws SQLException, RuntimeException {
        String createSql = "CREATE TABLE IF NOT EXISTS STUDENTS_TB" +
                "(ID INTEGER NOT NULL AUTO_INCREMENT, " +
                " NAME VARCHAR(255), " +
                " SUBJECT VARCHAR(255), " +
                " MARK INTEGER NOT NULL, " +
                " PRIMARY KEY (ID))";

        try {
            JDBCUtil.getStatement().executeUpdate(createSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Created table");

    }

    public static void insertStudent(Student student) throws SQLException, RuntimeException {
        String insertSql = "INSERT INTO STUDENTS_TB(NAME, SUBJECT, MARK) VALUES( "
                + "'" + student.getName() + "', "
                + "'" + student.getSubject() + "', "
                + "'" + student.getMark() + "')";

        try {
            JDBCUtil.getStatement().executeUpdate(insertSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("data added");


    }


    public static List<Student> getAllStudent() {

        String selectSql = "SELECT * FROM STUDENTS_TB";

        List<Student> students = new ArrayList<>();

        try {

            ResultSet resultSet = JDBCUtil.getStatement().executeQuery(selectSql);

            while (resultSet.next()) {

                students.add(new Student(
                        resultSet.getString("NAME"),
                        resultSet.getString("SUBJECT"),
                        resultSet.getInt("MARK")
                ));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;

    }



}
