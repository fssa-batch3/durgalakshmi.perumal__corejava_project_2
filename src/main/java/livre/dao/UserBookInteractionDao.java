package livre.dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
	import java.sql.SQLException;

import com.mysql.cj.jdbc.JdbcConnection;

	public class UserBookInteractionDao {
		
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

	    public void addUserBookInteraction(int userId, int readBookId) {
	        String insertQuery = "INSERT INTO UserBookInteraction (user_id, readbook_id) VALUES (?, ?)";

	        try (Connection connection = getConnection();  
	                PreparedStatement pst = connection.prepareStatement(insertQuery);) {
	        	pst.setInt(1, userId);
	        	pst.setInt(2, readBookId);
	        	pst.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


