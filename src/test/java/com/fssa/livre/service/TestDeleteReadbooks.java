package com.fssa.livre.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.livre.services.ReadbooksService;
import com.fssa.livre.services.exceptions.ServiceException;

public class TestDeleteReadbooks {

    private ReadbooksService readbooksService;

    @BeforeEach
    public void setUp() {
        // Initialize your service before each test.
        readbooksService = new ReadbooksService();
    }

    @Test
    public void testValidDelete() {
        // Assuming ID 12 exists in the database for testing.
        try {
            assertTrue(readbooksService.ReadbooksDelete(3));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("ServiceException should not be thrown for valid delete.");
        }
    }

    @Test
    public void testInvalidIDDelete() {
        // Assuming ID 40 does not exist in the database for testing.
        try {
            assertFalse(readbooksService.ReadbooksDelete(40));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("ServiceException should not be thrown for invalid delete.");
        }
    }
}
