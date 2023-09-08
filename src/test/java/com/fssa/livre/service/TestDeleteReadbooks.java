package com.fssa.livre.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.Test;

import com.fssa.livre.services.ReadbooksService;
import com.fssa.livre.services.exceptions.ServiceException;

class TestDeleteReadbooks {
 
    private ReadbooksService readbooksService;

    /**
     * Test for a valid delete of a Readbooks record.
     * 
     * This test method assumes that the ID 11 exists in the database for testing.
     * It attempts to delete the record and asserts that the deletion operation
     * returns true, indicating a successful deletion.
     */
    @Test 
    void testValidDelete() { 
        try {
            assertTrue(ReadbooksService.readbooksDelete(8));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("ServiceException should not be thrown for a valid delete.");
        }
    }

    /**
     * Test for an invalid ID during Readbooks record deletion.
     * This test method assumes that the ID 40 does not exist in the database for
     * testing. It attempts to delete a non-existent record and asserts that the
     * deletion operation returns false, indicating that the record was not deleted.
     */
    @Test
    void testInvalidIDDelete() {
        try {
            assertFalse(readbooksService.readbooksDelete(2));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail("ServiceException should not be thrown for an invalid delete.");
        }
    }
}
