package com.fssa.livre.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.livre.model.Readbooks;
import com.fssa.livre.services.ReadbooksService;
import com.fssa.livre.services.exceptions.ServiceException;

public class TestUpadteReadbooks {

    /**
     * Test for a valid update of Readbooks.
     * 
     * This test method creates a new instance of ReadbooksService, sets up a
     * Readbooks object with valid data, and verifies that the update operation
     * succeeds without exceptions.
     */
    @Test
    public void testValidUpdate() {
        ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks(1, "HOUSE OF FURIES", "imagelink-url", "pdf-link-url", "TRILLER");
        
        try {
            assertTrue(readbooksService.readbooksUpdate(readbooks));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test for an invalid update of Readbooks.
     * 
     * This test method creates a new instance of ReadbooksService, sets up a
     * Readbooks object with invalid data (non-existent ID), and verifies that the
     * update operation fails as expected by throwing a ServiceException.
     */
    @Test
    public void testInValidUpdate() {
        ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks(40, "Why Me?", "imagelink-url", "pdf-link-url", "TRILLER");
        
        try {
            assertFalse(readbooksService.readbooksUpdate(readbooks));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test for a null value in Readbooks.
     * 
     * This test method creates a new instance of ReadbooksService, sets up a
     * Readbooks object with null values, and verifies that the update operation
     * fails as expected by throwing a ServiceException.
     */
    @Test
    public void testNullValue() {
        ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks();
        
        try {
            assertFalse(readbooksService.readbooksUpdate(readbooks));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Test for an invalid book name.
     * 
     * This test method creates a new instance of ReadbooksService, sets up a
     * Readbooks object with an invalid book name, and verifies that the update
     * operation fails as expected by throwing a ServiceException.
     */
    @Test
    public void testInavlidBookName() {
        ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks(40, "dum@hh", "imagelink-url", "pdf-link-url", "TRILLER");
        
        try {
            assertFalse(readbooksService.readbooksUpdate(readbooks));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
