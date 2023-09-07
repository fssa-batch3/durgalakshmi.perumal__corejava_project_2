package com.fssa.livre.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
		// Connect to database
		public static Connection getConnection() throws SQLException {
//			String DB_URL ;
//			String DB_USER ;
//			String DB_PASSWORD;
//  
//			DB_URL = System.getenv("DB_URL");
//			DB_USER = System.getenv("DB_USER");
//			DB_PASSWORD = System.getenv("DB_PASSWORD");
			Connection connection = null;
		

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_project", "root", "123456");
//				connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		 
			} catch (SQLException e) {
				throw new RuntimeException("Unable to connect to database", e);

			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Database driver class is not found", e);
			}

			return connection;
		}

 }

