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
import com.fssa.livre.services.exceptions.ServiceException;
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
	            user.setname(rs.getString("name"));
	            user.setAge(rs.getInt("age"));
	            user.setPhoneNumber(rs.getLong("phoneNumber"));
	            return user;
	        }

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	    return null;
	}

	
	public static int getUserIdByEmail(String email) throws DAOException {
	    String selectQuery = "SELECT user_id FROM user WHERE email = ?";
	    try (Connection connection = ConnectionDb.getConnection();
	         PreparedStatement pst = connection.prepareStatement(selectQuery)) {
	        pst.setString(1, email);

	        try (ResultSet rs = pst.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt("user_id");
	            }
	        }
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	    
	    return -1; 
	}

	
	
	 public void updateUser(String email, String name, int age, String phoneNumber) throws DAOException {
	        String updateQuery = "UPDATE user SET name = ?, age = ?, phoneNumber = ? WHERE email = ?";
	        try (Connection connection = ConnectionDb.getConnection();
	             PreparedStatement pst = connection.prepareStatement(updateQuery)) {
	            pst.setString(1, name);
	            pst.setInt(2, age);
	            pst.setString(3, phoneNumber);
	            pst.setString(4, email);

	            int rowsUpdated = pst.executeUpdate();
	            if (rowsUpdated != 1) {
	                throw new DAOException("Failed to update user information");
	            }
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	    }
	
	 public static void updateUserProfile(User user) throws ServiceException {
	        String updateQuery = "UPDATE user SET name = ?, age = ?, phoneNumber = ? WHERE email = ?";

	        try (Connection connection = ConnectionDb.getConnection();
	             PreparedStatement pst = connection.prepareStatement(updateQuery);) {
	            pst.setString(1, user.getname());
	            pst.setInt(2, user.getAge());
	            pst.setLong(3, user.getPhoneNumber());
	            pst.setString(4, user.getEmail());

	            int rowsUpdated = pst.executeUpdate();

	            if (rowsUpdated == 0) {
	                throw new ServiceException("Failed to update user profile.");
	            }
	        } catch (SQLException e) {
	            throw new ServiceException(e);
	        }
	    }
	

	 

	public static User getUserById(int userId) throws DAOException {
	    String selectQuery = "SELECT * FROM user WHERE user_id = ?";
	    try (Connection connection = ConnectionDb.getConnection();
	         PreparedStatement pst = connection.prepareStatement(selectQuery);) {
	        pst.setInt(1, userId);

	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            User user = new User();
	            user.setUserId(rs.getInt("user_id"));
	            user.setEmail(rs.getString("email"));
	            user.setPassword(rs.getString("password"));
	            // Set other user properties as needed
	            return user;
	        } else {
	            return null; // User not found
	        }

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}



	
	 public static boolean updateUserDetailsByEmail(String email, String firstname, String lastname, int phoneNumber, int age) throws DAOException {
	        String updateQuery = "UPDATE user SET firstname = ?, lastname = ?, phonenumber = ?, age = ? WHERE email = ?";
	        try (Connection connection = ConnectionDb.getConnection();
	             PreparedStatement pst = connection.prepareStatement(updateQuery);) {
	            pst.setString(1, firstname);
	            pst.setString(2, lastname);
	            pst.setInt(3, phoneNumber);
	            pst.setInt(4, age);
	            pst.setString(5, email);

	            int rowsAffected = pst.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            throw new DAOException(e);
	        }
	    }

	

	
	/**
	 * Adds a new user to the database during the registration process.
	 *
	 * @param user The user object containing email and password to be registered.
	 * @return True if the registration is successful, false otherwise.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	 public static boolean register(User user) throws DAOException {
		    String insertQuery = "INSERT INTO user (email, password, name, phonenumber, age) VALUES (?, ?, ?, ?, ?)";
		    try (Connection connection = ConnectionDb.getConnection();
		         PreparedStatement pst = connection.prepareStatement(insertQuery)) {
		        pst.setString(1, user.getEmail());
		        pst.setString(2, user.getPassword());
		        pst.setString(3, user.getname());
		        pst.setLong(4, user.getPhoneNumber());
		        pst.setInt(5, user.getAge());

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
