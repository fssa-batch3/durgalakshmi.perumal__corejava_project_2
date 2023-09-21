package com.fssa.livre.service;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.livre.dao.UserDAO;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.Readbooks;
import com.fssa.livre.model.User;
import com.fssa.livre.services.ReadbooksService;
import com.fssa.livre.services.UserService;
import com.fssa.livre.services.exceptions.ServiceException;
import com.fssa.livre.validation.exceptions.InvalidUserException;

 class TestRegisterFeature {
	 
	 /**
	  * Tests successful user registration.
	  * - Creates a UserService and a User with valid credentials.
	  * - Asserts that registration succeeds.
	  * - Fails the test if a ServiceException is thrown.
	  *
	  * @throws ServiceException If an unexpected error occurs during registration.
	  */
	@Test
	 void testRegistrationSuccess() throws ServiceException { 
		UserService userService = new UserService();
		User user = new User("meena@gmail.com", "D@urg467", "Durga", 9551096952L, 23);
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail(); 
		}
	} 
	
	
	@Test
	 void testRegistrationFailByEmail() throws ServiceException {
		UserService userService = new UserService();
		User user = new User("durg@g", "D@urg467");
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			
		}
	}
	
	@Test
	 void testRegistrationFailByPassword() throws ServiceException {
		UserService userService = new UserService();
		User user = new User("durg@gmail.com", "dfgh-xfch gvb");
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}

	@Test
	void testUpdateUserDetailsByEmail() {
	    UserService userService = new UserService();
	    User user = new User("D@urg467","durg@gmail.com", "durga", "laks", 894678977, 18); // Provide a valid password
	        
	    try {
	        assertTrue(userService.registerUser(user));
	    } catch (ServiceException e) {
	        e.printStackTrace();
	        fail();
	    }
	}





}
