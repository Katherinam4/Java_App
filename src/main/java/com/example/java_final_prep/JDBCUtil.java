package com.example.java_final_prep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
    private static final String DB_URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12592259";
    private static final String DB_USER = "sql12592259";
    private static final String DB_PASSWORD = "x4gLGNFVVJ";




    private static final Connection connection;
    private static Statement statement;

    private  JDBCUtil() {

    }

    static {

        try {

            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Statement getStatement() {
        if(statement == null) {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return statement;
    }
}
