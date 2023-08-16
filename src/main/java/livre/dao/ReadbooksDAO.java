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

	
	
	public boolean ReadBooks(Readbooks readbooks) throws  DAOException {
		String insertQuery = "INSERT INTO readbooks (bookname ,imagelink ,pdflink ,category) VALUES (?, ?, ?, ?)";

		try(Connection connection = getConnection();
	    PreparedStatement pst = connection.prepareStatement(insertQuery); ){
			pst.setString(1, readbooks.getBookname()); 
			pst.setString(2, readbooks.getImagelink());
			pst.setString(3, readbooks.getPdflink());
			pst.setString(4, readbooks.getCategory());
   
			int rows = pst.executeUpdate();

	
			return (rows == 1);
			
		} catch (SQLException e) {

		throw new DAOException(e);
		}
	}

	
	
	
	
	//update
	
	public boolean updateBooks(Readbooks readbooks) throws DAOException {
	    String updateQuery = "UPDATE readbooks SET imagelink = ?, pdflink = ?, category = ? WHERE bookname = ?";

	    try (Connection connection = getConnection();
	         PreparedStatement updatepst = connection.prepareStatement(updateQuery);) {

	    	updatepst.setString(1, readbooks.getImagelink());
	    	updatepst.setString(2, readbooks.getPdflink());
	    	updatepst.setString(3, readbooks.getCategory());
	    	updatepst.setString(4, readbooks.getBookname());

	        int rows = updatepst.executeUpdate();

	        return (rows == 1);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public static boolean DeleteBooks(int id) throws DAOException{
		String deleteQuery = "DELETE FROM readbooks WHERE readbook_id = ?";
		try(Connection connect = getConnection();
			PreparedStatement deletePst = connect.prepareStatement(deleteQuery);){
			deletePst.setInt(1, id);
			int rows = deletePst.executeUpdate();
			return (rows ==1);
		}catch (SQLException e) {
			throw new DAOException(e);
		}
	}




	
	
}
