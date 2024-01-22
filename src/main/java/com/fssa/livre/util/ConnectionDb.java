package com.fssa.livre.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDb {
    // Connect to the database
    public static Connection getConnection() {
    	
    	String dbUrl = "jdbc:mysql://164.52.216.41:3306/durgalakshmi_perumal_corejava_project";
    	String dbUser = "koANCsD6BzM2";
    	String dbPassword = "aaf6cf5c-c149-4af3-8b7a-b43ec79d070b";
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		return DriverManager.getConnection(dbUrl,dbUser,dbPassword);
    				}
    		catch (Exception e) {

    			e.printStackTrace();

    			throw new RuntimeException(e);

    		}

    		

    	}



    	/**

    	 * 

    	 * @param connection

    	 * @param ps

    	 */

    	public static void close(Connection connection, PreparedStatement ps) {

    		try {

    			if (ps != null) {

    				ps.close();

    			}

    			if (connection != null) {

    				connection.close();

    			}

    		} catch (SQLException e) {

    			e.printStackTrace();

    		}

    	}



    	/**

    	 * 

    	 * @param connection

    	 * @param ps

    	 * @param rs

    	 */



    	public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {

    		try {

    			if (rs != null) {

    				rs.close();

    			}

    			if (ps != null) {

    				ps.close();

    			}

    			if (connection != null) {

    				connection.close();

    			}



    		} catch (SQLException e) {

    			e.printStackTrace();

    		}



    	}



    }











