package com.fssa.livre.service;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.livre.model.User;
import com.fssa.livre.services.UserService;
import com.fssa.livre.services.exceptions.ServiceException;

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
		User user = new User("durg@gmail.com", "D@urg467");
		try {
			assertTrue(userService.registerUser(user));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
}
