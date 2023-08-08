package livre.service;

import livre.services.*;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import livre.services.exceptions.ServiceException;

public class TestLoginFeature {
	@Test
	public void testLoginSuccess() { 
		UserService userService = new UserService();

		try {
			assertTrue(userService.loginUser("durga@gmail.com", "@Durga123"));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	
	//wrong password and email
	@Test
	public void testLoginFailByBothFields() {
		UserService userService = new UserService();
		try {
			assertFalse(userService.loginUser("durgalaks100gmail.com", "S2^trongpassword"));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
		
	}
	//wrong email
	@Test
	public void testLoginFailedByEmailField() {
		UserService userService = new UserService();
		try {
			assertFalse(userService.loginUser("Durgalaks@gmail.com", "Durga@90"));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	// wrong password
	@Test
	public void testLoginFailedByPasswordField() {
		UserService userService = new UserService();
		try {
			assertFalse(userService.loginUser("durgalaksh@gmail.com", "Durr2005&"));
		} catch (ServiceException e) {
			e.printStackTrace();
		
		}
	}
	
}
