package com.fssa.livre.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.livre.validation.UserValidator;
import com.fssa.livre.validation.exceptions.InvalidUserException;

public class TestPassword {
	//valid password
		@Test
		public void testValidPassword() {
			try {
				assertTrue(UserValidator.validatePassword("Durga@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	//without SpecialCharacters
		@Test 
		public void testInvalidPasswordWithoutSpecialCharacters() {
			try {
				assertFalse(UserValidator.validatePassword("Durga23"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	//Password  Without Numbers
		@Test
		public void testInvalidPasswordWithoutNumbers() {
			try {
				assertFalse(UserValidator.validatePassword("Durga@"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	//Password Without CapitalLetters
		@Test 
		public void testInvalidPasswordWithoutCapitalLetters() {
			try {
				assertFalse(UserValidator.validatePassword("durga@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	//Password Without SmallLetters
		@Test
		public void testInvalidPasswordWithoutSmallLetters() {
			try {
				assertFalse(UserValidator.validatePassword("DURGA@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//Password Shorter Length
		@Test
		public void testInvalidPasswordShorterLength() {
			try {
				assertFalse(UserValidator.validatePassword("Du@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
