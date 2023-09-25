package com.fssa.livre.services;

import java.util.List;

import com.fssa.livre.dao.UserRequestABookDAO;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.UserRequestABook;
import com.fssa.livre.services.exceptions.ServiceException;


public class UserRequestABookService {
	
	    private static UserRequestABookDAO userDao;

	    public UserRequestABookService() {
	    	   this.userDao = new UserRequestABookDAO();	    }

	    public static boolean requestBook(String email, String bookName, String imageUrl, String description) {
	        try {
	            return UserRequestABookDAO.insertBookRequest(email, bookName, imageUrl, description);
	        } catch (DAOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
//	    
//	    public List<UserRequestABook> getBookRequestsForLoggedInUser(String loggedInUserEmail) throws ServiceException {
//	        try {
//	            // Retrieve the user's ID based on the email
//	            int userId = userDao.getUserIdByEmail(loggedInUserEmail);
//
//	            // Replace this with your actual database query to retrieve book requests for the user
//	            List<UserRequestABook> bookRequests = UserRequestABookDAO.getBookRequestsForUser(userId);
//
//	            return bookRequests;
//	        } catch (DAOException e) {
//	            // Handle DAOException or rethrow as ServiceException
//	            throw new ServiceException(e);
//	        }
//	    }
//	    
	    // Define a method to get all book requests
	    public static List<UserRequestABook> getAllBookRequests() {
	        try {
	            // Call the DAO method to fetch all book requests
	            return userDao.getAllBookRequests();
	        } catch (DAOException e) {
	            e.printStackTrace();
	            return null; // Handle the exception as needed
	        }
	    }
	}

