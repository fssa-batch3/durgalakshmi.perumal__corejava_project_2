package com.fssa.livre.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.User;
import com.fssa.livre.util.ConnectionDb;

public class UserDAO {


	/**
	 * Retrieves a user's information from the database based on their email.
	 *
	 * @param email The email of the user to retrieve.
	 * @return The user object containing email and password, or null if not found.
	 * @throws DAOException If there is an issue with the database operation. 
	 */
	public static User getUserByEmail(String email) throws DAOException {
	    String selectQuery = "SELECT * FROM user WHERE email = ?";
	    try (Connection connection = ConnectionDb.getConnection();
	         PreparedStatement pst = connection.prepareStatement(selectQuery);) {
	        pst.setString(1, email);

	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            User user = new User();
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));

	            return user;
	        }

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	    return null;
	}

	
	
	/**
	 * Adds a new user to the database during the registration process.
	 *
	 * @param user The user object containing email and password to be registered.
	 * @return True if the registration is successful, false otherwise.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	public boolean register(User user) throws DAOException {
	    String insertQuery = "INSERT INTO user (email, password) VALUES (?, ?)";
	    try (Connection connection = ConnectionDb.getConnection();
	         PreparedStatement pst = connection.prepareStatement(insertQuery);) {
	        pst.setString(1, user.getEmail());
	        pst.setString(2, user.getPassword());

	        int rows = pst.executeUpdate();

	        return (rows == 1);
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}
	
	/**
	 * @return
	 * @throws DAOException
	 */
	public static List<User> getAllUsers() throws DAOException{
		final String selectAllUserQuery = "SELECT * FROM user";
		List<User> userList = new ArrayList<>();
		try (Connection connect = ConnectionDb.getConnection();
				Statement statement = connect.createStatement();
				ResultSet rs = statement.executeQuery(selectAllUserQuery)) {
			while(rs.next()) {
				int userId = rs.getInt("user_id");
				String userEmail = rs.getString("email");
				User user= new User(userId,userEmail);
				userList.add(user);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return userList;
	}

}
