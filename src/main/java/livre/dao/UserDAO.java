package livre.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import livre.dao.excepion.DAOException;
import livre.model.User;


public class UserDAO {


	// Connect to database
		public static Connection getConnection() throws SQLException {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "123456");
			return connection;
		}

		
		
		// Get user from DB - Login
		public boolean login(String email, String password) throws  DAOException {
			String selectQuery = "SELECT * FROM user WHERE email = ? AND password = ?";
			try(Connection connection = getConnection();
		    PreparedStatement pst = connection.prepareStatement(selectQuery); ){
				pst.setString(1, email); 
				pst.setString(2, password);
				ResultSet rs = pst.executeQuery();
				return rs.next();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			throw new DAOException(e);
			}
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
		

