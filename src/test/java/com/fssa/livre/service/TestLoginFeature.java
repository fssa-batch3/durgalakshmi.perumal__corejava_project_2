package com.fssa.livre.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.fssa.livre.services.*;
import com.fssa.livre.services.exceptions.ServiceException;

 class TestLoginFeature {
	/**
	 * This test method verifies a successful user login with valid email and password.
	 * It uses UserService to attempt a login and asserts that it returns true.
	 * If a ServiceException occurs, the test fails.
	 */
	@Test
 void testLoginSuccess() { 
		UserService userService = new UserService();
		try {
			assertTrue(userService.loginUser("durga@gmail.com", "@Durga123"));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	/**
	 * This test method verifies a login failure when both email and password are incorrect.
	 * It uses UserService to attempt a login and asserts that it returns false.
	 * If a ServiceException occurs, it is handled without failing the test.
	 */
	@Test 
	void testLoginFailByBothFields() {
		
		UserService userService = new UserService();
		try {
			assertFalse(userService.loginUser("durgalaks100gmail.com", "S2^trongpassword")); 
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
		
	} 


    /**
    * This test method verifies a login failure when the email is incorrect.
    * It uses UserService to attempt a login and asserts that it returns false.
    * If a ServiceException occurs, it is handled without failing the test.
    */
	@Test
void testLoginFailedByEmailField() {
		UserService userService = new UserService();
		try {
			assertFalse(userService.loginUser("Durgalaks@gmail.com", "Durga@90"));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	/**
	 * This test method verifies a login failure when the password is incorrect.
	 * It uses UserService to attempt a login and asserts that it returns false.
	 * If a ServiceException occurs, it is handled without failing the test.
	 */
	@Test
 void testLoginFailedByPasswordField() {
		UserService userService = new UserService();
		try {
			assertFalse(userService.loginUser("durgalaksh@gmail.com", "Durr2005&"));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
}
