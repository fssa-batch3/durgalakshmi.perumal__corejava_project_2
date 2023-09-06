package com.fssa.livre.service;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.livre.model.User;
import com.fssa.livre.services.UserService;
import com.fssa.livre.services.exceptions.ServiceException;

 class TestRegisterFeature {
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
