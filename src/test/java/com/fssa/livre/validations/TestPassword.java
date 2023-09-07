package com.fssa.livre.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.livre.validation.UserValidator;
import com.fssa.livre.validation.exceptions.InvalidUserException;

 class TestPassword {
	//valid password
		@Test
		 void testValidPassword() {
			try {
				assertTrue(UserValidator.validatePassword("Durga@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	//without SpecialCharacters
		@Test 
		 void testInvalidPasswordWithoutSpecialCharacters() {
			try {
				assertFalse(UserValidator.validatePassword("Durga23"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	//Password  Without Numbers
		@Test
		 void testInvalidPasswordWithoutNumbers() {
			try {
				assertFalse(UserValidator.validatePassword("Durga@"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	//Password Without CapitalLetters
		@Test 
		 void testInvalidPasswordWithoutCapitalLetters() {
			try {
				assertFalse(UserValidator.validatePassword("durga@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	//Password Without SmallLetters
		@Test
		 void testInvalidPasswordWithoutSmallLetters() {
			try {
				assertFalse(UserValidator.validatePassword("DURGA@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//Password Shorter Length
		@Test
	 void testInvalidPasswordShorterLength() {
			try {
				assertFalse(UserValidator.validatePassword("Du@123"));
			} catch (InvalidUserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
}
