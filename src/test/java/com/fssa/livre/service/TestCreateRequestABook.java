package com.fssa.livre.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.livre.services.UserRequestABookService;
import com.fssa.livre.services.exceptions.ServiceException;

public class TestCreateRequestABook {
	@Test
	void testRequestBook_Successful() {
	    // Arrange
	    UserRequestABookService userServiceRequestABookService = new UserRequestABookService();
	    String email = "anjali@gmail.com";
	    String bookName = "BookName";
	    String imageUrl = "ImageUrl";
	    String description = "Description";

	    // Act
	    try {
	        boolean result = userServiceRequestABookService.requestBook(email, bookName, imageUrl, description);

	        // Assert
	        assertTrue(result);
	    } catch (Exception e) {
	        fail(e.getMessage());
	    }
	}


     

}
