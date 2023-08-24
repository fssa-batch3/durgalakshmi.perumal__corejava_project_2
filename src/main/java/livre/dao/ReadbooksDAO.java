package livre.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;
import livre.dao.excepion.DAOException;
import livre.model.Readbooks;
import livre.model.User;

public class ReadbooksDAO {

	
	// Connect to database
public static Connection getConnection() throws SQLException {
//		String DB_URL;
//		String DB_USER;
//		String DB_PASSWORD;
//
//		if (System.getenv("CI") != null) {
//			DB_URL = System.getenv("DB_URL");
//			DB_USER = System.getenv("DB_USER");
//			DB_PASSWORD = System.getenv("DB_PASSWORD");
//		} else {
//			Dotenv env = Dotenv.load();
//			DB_URL = env.get("DB_URL");
//			DB_USER = env.get("DB_USER");
//			DB_PASSWORD = env.get("DB_PASSWORD");
//		}
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "123456");
		return connection;
}

	//AddReadBooks
	
public boolean addReadBooks(Readbooks readbooks) throws DAOException {
    // SQL query to insert new book information into the readbooks table
    String insertQuery = "INSERT INTO readbooks (bookname, imagelink, pdflink, category) VALUES (?, ?, ?, ?)";

    try (Connection connection = getConnection();  // Establish a database connection
         PreparedStatement pst = connection.prepareStatement(insertQuery);) {

        // Set values for parameters in the prepared statement
        pst.setString(1, readbooks.getBookname());  
        pst.setString(2, readbooks.getImagelink());  
        pst.setString(3, readbooks.getPdflink());    
        pst.setString(4, readbooks.getCategory());    

        // Execute the insert operation and get the number of affected rows
        int rows = pst.executeUpdate();

        // Check if exactly one row was inserted, and return true.
        return (rows == 1);
    } catch (SQLException e) {
        // If a database exception occurs, wrap it in a custom DAOException and throw it
        throw new DAOException(e);
    }
}

	
	
	
	
	//update ReadBooks
	
	public boolean updateBooks(Readbooks readbooks) throws DAOException {
	    // SQL query to update book information based on the book name
	    String updateQuery = "UPDATE readbooks SET imagelink = ?, pdflink = ?, category = ? WHERE bookname = ?";

	    try (Connection connection = getConnection();  // Establish a database connection
	         PreparedStatement updatepst = connection.prepareStatement(updateQuery);) {

	        // Set values for parameters in the prepared statement
	        updatepst.setString(1, readbooks.getImagelink());  
	        updatepst.setString(2, readbooks.getPdflink());    
	        updatepst.setString(3, readbooks.getCategory());   
	        updatepst.setString(4, readbooks.getBookname());   

	        // Execute the update operation and get the number of affected rows
	        int rows = updatepst.executeUpdate();

	        // Check if exactly one row was updated, and return true if so
	        return (rows == 1);
	    } catch (SQLException e) {
	        // If a database exception occurs, wrap it in a custom DAOException and throw it
	        throw new DAOException(e);
	    }
	}

	
	
	//DeleteReadBooks

	public static boolean DeleteBooks(int id) throws DAOException {
	    // Define the SQL query to delete a book entry with a specific id
	    String deleteQuery = "DELETE FROM readbooks WHERE readbook_id = ?";

	    try (Connection connect = getConnection();  // Establish a database connection
	         PreparedStatement deletePst = connect.prepareStatement(deleteQuery);) {
	        
	        // Bind the id parameter to the prepared statement
	        deletePst.setInt(1, id);
	        
	        // Execute the deletion operation and get the number of affected rows
	        int rows = deletePst.executeUpdate();

	        // Check if exactly one row was deleted, and return true 
	        return (rows == 1);
	    } catch (SQLException e) {
	        // If a database exception occurs, wrap it in a custom DAOException and throw it
	        throw new DAOException(e);
	    }
	}




	
	
}
