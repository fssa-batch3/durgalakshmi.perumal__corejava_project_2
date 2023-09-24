package com.fssa.livre.services;

import java.sql.SQLException;
import java.util.List;

import com.fssa.livre.dao.ReadbooksDAO;
import com.fssa.livre.dao.UserBooksDAO;
import com.fssa.livre.dao.UserDAO;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.Readbooks;
import com.fssa.livre.model.User;
import com.fssa.livre.model.UserBooks;
import com.google.protobuf.ServiceException;

public class UserBooksService {

	private static UserBooksDAO userBooksDAO = new UserBooksDAO();

	public static boolean addUserBook(UserBooks user_books) throws ServiceException {
		if (user_books == null) {
			throw new ServiceException("Invalid ");
		}
		if (user_books.getUserId() <= 0)
			throw new ServiceException("Invalid user book");
		if (user_books.getReadBookId() <= 0)
			throw new ServiceException("Invalid user book data");
		try {
			return userBooksDAO.addUserBook(user_books);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	 public void updateUserBook(int userId, int bookId, long duration, String status) throws ServiceException {
	        try {
	            userBooksDAO.updateUserBook(userId, bookId, duration, status);
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }
	
	
	
	public static List<UserBooks> getUserBooksByUserId(int userId) throws ServiceException {
		try {
			UserBooksDAO userBooksDAO = new UserBooksDAO();
			return userBooksDAO.getUserBooksByUserId(userId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}


	  public boolean doesUserHaveBook(int userId, int bookId) throws ServiceException {
	        try {
	            // Call the DAO method to check if the user has the book
	            return UserBooksDAO.isUserBookExists(userId, bookId);
	        } catch (DAOException e) {
	            throw new ServiceException("Error checking if the user has the book", e);
	        }
	    }
}
