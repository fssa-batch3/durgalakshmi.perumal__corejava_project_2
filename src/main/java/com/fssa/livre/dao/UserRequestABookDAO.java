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

    public static int getUserIdByEmail(String email) throws DAOException {
        String selectQuery = "SELECT user_id FROM your_user_table WHERE email = ?";
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
    
    
//    public List<UserRequestABook> getBookRequestsForUser(int userId) throws DAOException {
//        List<UserRequestABook> bookRequests = new ArrayList<>();
//
//        String selectQuery = "SELECT * FROM book_requests WHERE user_id = ?";
//
//        try (Connection connection = ConnectionDb.getConnection();
//             PreparedStatement pst = connection.prepareStatement(selectQuery)) {
//            pst.setInt(1, userId);
//
//            try (ResultSet rs = pst.executeQuery()) {
//                while (rs.next()) {
//                    int requestId = rs.getInt("request_id");
//
//                    UserRequestABook bookRequest = new UserRequestABook(requestId, userId, );
//
//                    bookRequests.add(bookRequest);
//                }
//            }
//        } catch (SQLException e) {
//            throw new DAOException(e);
//        }
//
//        return bookRequests;
//    }
//    
    
    public List<UserRequestABook> getAllBookRequests() throws DAOException {
        List<UserRequestABook> bookRequests = new ArrayList<>();

        String selectQuery = "SELECT * FROM book_requests";

        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement pst = connection.prepareStatement(selectQuery);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                // Retrieve data from the result set and create BookRequest objects
                String email = rs.getString("email");
                String bookName = rs.getString("book_name");
                String imageUrl = rs.getString("image_url");
                String description = rs.getString("description");
                String status = rs.getString("status");

                // Create a BookRequest object
                UserRequestABook bookRequest = new UserRequestABook(email, bookName, imageUrl, description, status);

                // Add the book request to the list
                bookRequests.add(bookRequest);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return bookRequests;
    }
}
