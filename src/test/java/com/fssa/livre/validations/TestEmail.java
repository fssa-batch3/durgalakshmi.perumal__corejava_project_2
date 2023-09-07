package com.fssa.livre.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.livre.validation.UserValidator;
import com.fssa.livre.validation.exceptions.InvalidUserException;

 class TestEmail { 
	@Test
//valid email
	 void testValidEmail() {
		try {
			assertTrue(UserValidator.validateEmail("durgalakshmi@gmail.com"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}
	// no special character in email
@Test

	 void testInvalidEmailMissingAt() { 
		try {
			assertFalse(UserValidator.validateEmail("durgalaksgmail.com"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	// no dough in email
@Test

      void testInvalidEmailMissingPeriod() {
		try {
			assertFalse(UserValidator.validateEmail("durga@gmailcom"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
