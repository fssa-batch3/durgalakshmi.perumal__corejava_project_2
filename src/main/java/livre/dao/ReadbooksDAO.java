package livre.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import livre.dao.excepion.DAOException;
import livre.model.Readbooks;
import livre.model.User;

public class ReadbooksDAO {

	
	// Connect to database
	public static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livre", "root", "123456");
		return connection;
	}

	
	
	public boolean READBOOKS(Readbooks readbooks) throws  DAOException {
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
	         PreparedStatement pst = connection.prepareStatement(updateQuery);) {

	        pst.setString(1, readbooks.getImagelink());
	        pst.setString(2, readbooks.getPdflink());
	        pst.setString(3, readbooks.getCategory());
	        pst.setString(4, readbooks.getBookname());

	        int rows = pst.executeUpdate();

	        return (rows > 0);

	    } catch (SQLException e) {
	        throw new DAOException(e);
	    }
	}




	
	
}
