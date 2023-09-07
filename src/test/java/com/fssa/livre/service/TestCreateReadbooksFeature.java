package com.fssa.livre.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.livre.model.Readbooks;
import com.fssa.livre.services.ReadbooksService;
import com.fssa.livre.services.exceptions.ServiceException;

 class TestCreateReadbooksFeature {
	 /**
	  * This method tests the creation of a Readbooks product with valid input.
	  *  Creates a ReadbooksService instance.
	  *  Creates a Readbooks object with valid attributes.
	  *  Asserts that adding the Readbooks product succeeds.
	  *  Fails the test if a ServiceException is thrown. 
	  */
	 @Test
	 void testCreateProduct() {
	     ReadbooksService readbooksService = new ReadbooksService(); 
	     Readbooks readbooks = new Readbooks("Are You", "image-link-url", "pdf-link-url", "ADVENTURE");

	     try {
	         assertTrue(readbooksService.addReadBooks(readbooks));
	     } catch (ServiceException e) {
	         e.printStackTrace();
	         fail();
	     }
	 } 
 
	 /**
	  * This method tests the creation of a Readbooks product with a null value.
	  *  Creates a ReadbooksService instance.
	  *  Sets the Readbooks object to null.
	  *  Asserts that adding the Readbooks product fails (returns false).
	  *  Handles any ServiceException by printing a stack trace.
	  */
	 @Test
	 void testNullProduct() {
	     ReadbooksService readbooksService = new ReadbooksService();
	     Readbooks readbooks = null;

	     try {
	         assertFalse(readbooksService.addReadBooks(readbooks));
	     } catch (ServiceException e) {
	         e.printStackTrace();
	     }
	 }

	 /**
	  * This method tests the creation of a Readbooks product with an invalid book name.
	  *  Creates a ReadbooksService instance.
	  *  Creates a Readbooks object with an invalid book name.
	  *  Asserts that adding the Readbooks product fails (returns false).
	  *  Handles any ServiceException by printing a stack trace.
	  */
	 @Test
	 void testInavlidBookName() {
	     ReadbooksService readbooksService = new ReadbooksService();
	     Readbooks readbooks = new Readbooks(1, "1D@rk", "image-link-url", "pdf-link-url", "TRILLER");

	     try {
	         assertTrue(readbooksService.addReadBooks(readbooks));
	     } catch (ServiceException e) {
	         e.printStackTrace();
	     }
	 }

	 /**
	  * This method tests the creation of a Readbooks product with an invalid category.
	  *  Creates a ReadbooksService instance.
	  *  Creates a Readbooks object with an invalid category.
	  *  Asserts that adding the Readbooks product fails (returns false).
	  *  Handles any ServiceException by printing a stack trace.
	  */
	 @Test
	 void testInValidCategory() {
	     ReadbooksService readbooksService = new ReadbooksService();
	     Readbooks readbooks = new Readbooks(1, "you", "image-link-url", "pdf-link-url", "WOw");

	     try {
	         assertTrue(readbooksService.addReadBooks(readbooks));
	     } catch (ServiceException e) {
	         e.printStackTrace();
	     }
	 }

}


