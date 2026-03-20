package com.example.wwwmidterm.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String  URL = "jdbc:mysql://localhost:3306/qlchungcu?useUnicode=true&characterEncoding=UTF-8";
    private static final String  user = "root";
    private static final String  password = "";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL driver loaded.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,user,password);
    }
}

