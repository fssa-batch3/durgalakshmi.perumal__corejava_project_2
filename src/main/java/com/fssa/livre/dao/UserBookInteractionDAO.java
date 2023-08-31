package com.fssa.livre.dao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.livre.util.ConnectionDb;

	public class UserBookInteractionDAO {
		

		/**
		 * Adds a user-book interaction to the database.
		 *
		 * @param userId The ID of the user involved in the interaction.
		 * @param readBookId The ID of the book involved in the interaction.
		 */
		public void addUserBookInteraction(int userId, int readBookId) {
		    String insertQuery = "INSERT INTO UserBookInteraction (user_id, readbook_id) VALUES (?, ?)";

		    try (Connection connection = ConnectionDb.getConnection();  
		         PreparedStatement pst = connection.prepareStatement(insertQuery);) {
		        // Set values for the parameters
		        pst.setInt(1, userId);
		        pst.setInt(2, readBookId);
		        
		        // Execute the query to insert the interaction
		        pst.executeUpdate();
		    } catch (SQLException e) {
		        // Print the stack trace if an exception occurs
		        e.printStackTrace();
		    }
		}

	}


