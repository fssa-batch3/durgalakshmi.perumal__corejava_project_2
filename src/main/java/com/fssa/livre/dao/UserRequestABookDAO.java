package com.fssa.livre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.User;
import com.fssa.livre.model.UserRequestABook;
import com.fssa.livre.util.ConnectionDb;
import java.util.ArrayList;

public class UserRequestABookDAO {

    public static boolean insertBookRequest(String email, String bookName, String imageUrl, String description) throws DAOException {
        String insertQuery = "INSERT INTO book_requests (email, book_name, image_url, description, status) VALUES (?, ?, ?, ?, 'Pending')";

        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement pst = connection.prepareStatement(insertQuery);) {

         

            pst.setString(1, email);
            pst.setString(2, bookName);
            pst.setString(3, imageUrl);
            pst.setString(4, description);

            int rowsAffected = pst.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public boolean updateAcceptStatus(String requestId, String newStatus) {
        String updateQuery = "UPDATE book_requests SET status = ? WHERE id = ?";

        try (Connection connection = ConnectionDb.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newStatus);
            preparedStatement.setString(2, requestId);

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean updateDeclineStatus(int requestId, String newStatus, String adminReason) {
        String updateQuery = "UPDATE book_requests SET status = ? WHERE id = ?";

        try (Connection connection = ConnectionDb.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
        	  preparedStatement.setInt(1, requestId);
            preparedStatement.setString(2, newStatus);
           

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
    
    
    public static List<UserRequestABook> getBookRequestsForUser(String email) throws DAOException {
        List<UserRequestABook> bookRequests = new ArrayList<>();

        String selectQuery = "SELECT * FROM book_requests WHERE email = ?";

        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement pst = connection.prepareStatement(selectQuery)) {
            pst.setString(1, email);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int requestId = rs.getInt("id");
                    String userEmail = rs.getString("email");
                    String bookName = rs.getString("book_name");
                    String imageUrl = rs.getString("image_url");
                    String status = rs.getString("status");
                    String declineReason = rs.getString("admin_reason");
                    String description = rs.getString("description");

                    // Create a UserRequestABook object and add it to the list
                    UserRequestABook bookRequest = new UserRequestABook(requestId, userEmail, bookName, imageUrl, status, declineReason, description);
                    bookRequests.add(bookRequest);
                }
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return bookRequests;
    }

    public List<UserRequestABook> getAllBookRequests() throws DAOException {
        List<UserRequestABook> bookRequests = new ArrayList<>();

        String selectQuery = "SELECT * FROM book_requests";

        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement pst = connection.prepareStatement(selectQuery);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int requestId = rs.getInt("id"); 
                String email = rs.getString("email");
                String bookName = rs.getString("book_name");
                String imageUrl = rs.getString("image_url");
                String description = rs.getString("description");
                String status = rs.getString("status");

                UserRequestABook bookRequest = new UserRequestABook(requestId, email, bookName, imageUrl, description, status);

                bookRequests.add(bookRequest);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return bookRequests;
    }

}
