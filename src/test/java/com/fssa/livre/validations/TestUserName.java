package com.fssa.livre.validations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.livre.validation.ReadbooksValidator;
import com.fssa.livre.validation.exceptions.InvalidBooksException;


public class TestUserName {

	 // Valid name with only letters and spaces
    @Test
    public void testValidName() {
        try {
			assertTrue(ReadbooksValidator.validateReadBookName("Durga lakshmi"));
		} catch (InvalidBooksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Valid name with letters, numbers, and spaces
    @Test
    public void testValidNameWithNumbers() {
        try {
			assertTrue(ReadbooksValidator.validateReadBookName("Durga lakshmi 123"));
		} catch (InvalidBooksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Invalid name with special characters
    @Test
    public void testInvalidNameWithSpecialCharacters() {
        try {
			assertFalse(ReadbooksValidator.validateReadBookName("Durga@lakshmi"));
		} catch (InvalidBooksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Invalid name with special characters and spaces
    @Test
    public void testInvalidNameWithSpecialCharactersAndSpaces() {
        try {
			assertFalse(ReadbooksValidator.validateReadBookName("Durga * Lakshmi"));
		} catch (InvalidBooksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Invalid name with special characters, letters, and numbers
    @Test
    public void testInvalidNameWithSpecialCharactersLettersNumbers() {
        try {
			assertFalse(ReadbooksValidator.validateReadBookName("Durga$123"));
		} catch (InvalidBooksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
