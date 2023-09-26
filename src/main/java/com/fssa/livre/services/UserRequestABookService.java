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
	    
	    private UserRequestABookDAO UserDao; 

	    public UserRequestABookService(UserRequestABookDAO userDao) {
	        this.userDao = userDao;
	    }
	    public static List<UserRequestABook> getBookRequestsForLoggedInUser(String loggedInUserEmail) throws ServiceException {
	        try {
	            List<UserRequestABook> bookRequests = UserRequestABookDAO.getBookRequestsForUser(loggedInUserEmail);

	            return bookRequests;
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }

	    public boolean updateDeclineStatus(String requestId, String newStatus) {
	        UserRequestABookDAO userRequestABookDAO = new UserRequestABookDAO();

	        return userRequestABookDAO.updateAcceptStatus(requestId, newStatus);
	    }
	    
	    
	    public boolean updateAcceptStatus(String requestId, String newStatus) {
	        UserRequestABookDAO userRequestABookDAO = new UserRequestABookDAO();

	        return userRequestABookDAO.updateAcceptStatus(requestId, newStatus);
	    }
	    
	    public static List<UserRequestABook> getAllBookRequests() {
	        try {
	            return userDao.getAllBookRequests();
	        } catch (DAOException e) {
	            e.printStackTrace();
	            return null; 
	        }
	    }
	}

