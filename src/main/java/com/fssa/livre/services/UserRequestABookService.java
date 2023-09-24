package com.fssa.livre.services;

import com.fssa.livre.dao.UserRequestABookDAO;
import com.fssa.livre.dao.exception.DAOException;


public class UserRequestABookService {
	
	    private UserRequestABookDAO userDao;

	    public UserRequestABookService(UserRequestABookDAO userDao) {
	        this.userDao = userDao;
	    }

	    public boolean requestBook(String email, String bookName, String imageUrl, String description) {
	        try {
	            return UserRequestABookDAO.insertBookRequest(email, bookName, imageUrl, description);
	        } catch (DAOException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}


