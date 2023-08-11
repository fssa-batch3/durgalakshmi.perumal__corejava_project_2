package livre.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
import livre.dao.excepion.DAOException;
import livre.model.User;


public class UserDAO {


	// Connect to database
		public static Connection getConnection() throws SQLException {
//			String DB_URL;
//			String DB_USER;
//			String DB_PASSWORD;
//
//			if (System.getenv("CI") != null) {
//				DB_URL = System.getenv("DB_URL");
//				DB_USER = System.getenv("DB_USER");
//				DB_PASSWORD = System.getenv("DB_PASSWORD");
//			} else {
//				Dotenv env = Dotenv.load();
//				DB_URL = env.get("DB_URL");
//				DB_USER = env.get("DB_USER");
//				DB_PASSWORD = env.get("DB_PASSWORD");
//			}
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "123456");
			return connection;
		}

		
		
		// Get user from DB - Login
		public User getUserByEmail(String email) throws  DAOException {
			String selectQuery = "SELECT * FROM user WHERE email = ?";
			try(Connection connection = getConnection();
		    PreparedStatement pst = connection.prepareStatement(selectQuery); ){
				pst.setString(1, email); 
//			
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
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

		// Add new user to DB - Register
		public boolean register(User user) throws  DAOException {
			String insertQuery = "INSERT INTO user (email, password) VALUES (?, ?)";
		try(Connection connection = getConnection();
		PreparedStatement pst = connection.prepareStatement(insertQuery);){
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());
			
			// Execute the query on database
			int rows = pst.executeUpdate();
			
			// Return successful or not
			return (rows == 1);
		}
		catch (SQLException e) {
			throw new DAOException(e);
		}

		}
		}	
		

