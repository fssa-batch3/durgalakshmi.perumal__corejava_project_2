package com.fssa.livre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.User;
import com.fssa.livre.util.ConnectionDb;

public class UserRequestABookDAO {

    public static boolean insertBookRequest(String email, String bookName, String imageUrl, String description) throws DAOException {
        String insertQuery = "INSERT INTO book_requests (user_id, book_name, image_url, description, status) VALUES (?, ?, ?, ?, 'Pending')";

        try (Connection connection = ConnectionDb.getConnection();
             PreparedStatement pst = connection.prepareStatement(insertQuery);) {

            int userId = getUserIdByEmail(email);
            if (userId == -1) {
                return false;
            }

            pst.setInt(1, userId);
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
}
