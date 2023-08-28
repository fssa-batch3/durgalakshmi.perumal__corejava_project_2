package livre.dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
	import java.sql.SQLException;

import com.mysql.cj.jdbc.JdbcConnection;

	public class UserBookInteractionDAO {
		
		// Connect to database
		public static Connection getConnection() throws SQLException {
//				String DB_URL;
//				String DB_USER;
//				String DB_PASSWORD;
		//
//				if (System.getenv("CI") != null) {
//					DB_URL = System.getenv("DB_URL");
//					DB_USER = System.getenv("DB_USER");
//					DB_PASSWORD = System.getenv("DB_PASSWORD");
//				} else {
//					Dotenv env = Dotenv.load();
//					DB_URL = env.get("DB_URL");
//					DB_USER = env.get("DB_USER");
//					DB_PASSWORD = env.get("DB_PASSWORD");
//				}
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "123456");
				return connection;
		}
		/**
		 * Adds a user-book interaction to the database.
		 *
		 * @param userId The ID of the user involved in the interaction.
		 * @param readBookId The ID of the book involved in the interaction.
		 */
		public void addUserBookInteraction(int userId, int readBookId) {
		    String insertQuery = "INSERT INTO UserBookInteraction (user_id, readbook_id) VALUES (?, ?)";

		    try (Connection connection = getConnection();  
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


