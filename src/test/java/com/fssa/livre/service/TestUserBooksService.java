package com.fssa.livre.service;
import java.util.ArrayList;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.livre.dao.UserBooksDAO;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.UserBooks;
import com.fssa.livre.services.ReadbooksService;
import com.fssa.livre.services.UserBooksService;
import com.fssa.livre.validation.exceptions.InvalidBooksException;
import com.google.protobuf.ServiceException;

public class TestUserBooksService {
	

    @Test
    void testAddUserBook() {
        UserBooksService userBooksService = new UserBooksService();
        UserBooks userBook = new UserBooks(1, 1, 1, true);

        try {
            assertTrue(userBooksService.addUserBook(userBook));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }
    

    
    @Test
    void testGetUserBookByUserId() throws DAOException {
        // Create a test user and insert it into the database
        int testUserId = 1; // Replace with a valid user ID
        int testReadBookId = 1; // Replace with a valid read book ID
        boolean testStatus = true;
        
        // Insert the test user into the database using a test utility method
        
        // Call the getUserBooksByUserId method to retrieve user books
        List<UserBooks> userBooksList = UserBooksDAO.getUserBooksByUserId(testUserId);
        
        // Ensure that the userBooksList is not null and contains at least one user book
        assertNotNull(userBooksList);
        assertFalse(userBooksList.isEmpty());
        
        // Verify that the user book in the list matches the expected values
        UserBooks userBook = userBooksList.get(0);
        assertEquals(testUserId, userBook.getUserId());
        assertEquals(testReadBookId, userBook.getReadBookId());
        assertEquals(testStatus, userBook.isStatus());
    }

}
