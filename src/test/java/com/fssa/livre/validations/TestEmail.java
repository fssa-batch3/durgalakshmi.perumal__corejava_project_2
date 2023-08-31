package com.fssa.livre.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.livre.validation.UserValidator;

public class TestEmail {
	@Test
//valid email
	public void testValidEmail() {
		assertTrue(UserValidator.validateEmail("durgalakshmi@gmail.com"));
	
	}
	// no special character in email
@Test

	public void testInvalidEmailMissingAt() {
		assertFalse(UserValidator.validateEmail("durgalaksgmail.com"));
	
	}
	// no dough in email
@Test

	public void testInvalidEmailMissingPeriod() {
		assertFalse(UserValidator.validateEmail("durga@gmailcom"));
	
	}
}
