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
		String DB_URL ;
		String DB_USER ;
		String DB_PASSWORD;

		DB_URL = System.getenv("DB_URL");
		DB_USER = System.getenv("DB_USER");
		DB_PASSWORD = System.getenv("DB_PASSWORD");
		Connection connection = null;

		try {

		
			Class.forName("com.mysql.cj.jdbc.Driver");
//					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "123456");
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Unable to connect to database", e);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Database driver class is not found", e);
		}

		return connection;
	}

	/**
	 * Retrieves a user's information from the database based on their email.
	 *
	 * @param email The email of the user to retrieve.
	 * @return The user object containing email and password, or null if not found.
	 * @throws DAOException If there is an issue with the database operation.
	 */
	public User getUserByEmail(String email) throws DAOException {
	    String selectQuery = "SELECT * FROM user WHERE email = ?";
	    try (Connection connection = getConnection();
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
	    try (Connection connection = getConnection();
	         PreparedStatement pst = connection.prepareStatement(insertQuery);) {
	        pst.setString(1, user.getEmail());
	        pst.setString(2, user.getPassword());

	        int rows = pst.executeUpdate();

	        return (rows == 1);
	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}

}
