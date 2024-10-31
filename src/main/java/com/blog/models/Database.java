package com.blog.models;

import java.sql.*;

public class Database {

    // Database Info
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String dbusername = "SYSTEM";
    private static final String dbpassword = "youssef3334AB";

    // Load the driver once
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading Oracle JDBC Driver: " + e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, dbusername, dbpassword);
    }

    public static User getUserByUsernameAndPassword(String username, String password) {
        String sql = "SELECT id, username, password FROM users WHERE username = ? AND password = ?";
        
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            System.out.println("Connected to Database and Executing Query.");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), "");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return null;
    }
}
