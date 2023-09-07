package com.fssa.livre.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    // Connect to the database
    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = "jdbc:mysql://localhost:3306/web_project";
            String dbUser = "root";
            String dbPassword = "123456";

            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to the database", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Database driver class is not found", e);
        }

        return connection;
    }
}
