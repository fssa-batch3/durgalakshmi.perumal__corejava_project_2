package com.fssa.livre.validations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.livre.validation.ReadbooksValidator;
import com.fssa.livre.validation.exceptions.InvalidBooksException;

 class TestCategory {
	 // Valid book categories
    @Test
    void testValidBookCategories() {
        try {
            assertTrue(ReadbooksValidator.validateReadBookcategory("ADVENTURE"));
            assertTrue(ReadbooksValidator.validateReadBookcategory("THRILLER"));
            assertTrue(ReadbooksValidator.validateReadBookcategory("ROMANTIC"));
            assertTrue(ReadbooksValidator.validateReadBookcategory("COMEDY"));
            assertTrue(ReadbooksValidator.validateReadBookcategory("CLASSIC"));
            assertTrue(ReadbooksValidator.validateReadBookcategory("HORROR"));
            assertTrue(ReadbooksValidator.validateReadBookcategory("DEVOTIONAL"));
        } catch (InvalidBooksException e) {
            fail(e.getMessage());
        }
    }

    // Invalid book category (not in predefined categories)
    @Test
     void testInvalidBookCategory() {
        try {
            assertFalse(ReadbooksValidator.validateReadBookcategory("SCIFI"));
        } catch (InvalidBooksException e) {
            assertEquals("The book category must be adventure|thriller|romantic|comedy|classic|horror|devotional", e.getMessage());
        }
    }

    // Null book category
    @Test
    void testNullBookCategory() {
        assertThrows(InvalidBooksException.class, () -> {
        	ReadbooksValidator.validateReadBookcategory(null);
        });
    }

    // Empty book category
    @Test
    void testEmptyBookCategory() {
        assertThrows(InvalidBooksException.class, () -> {
        	ReadbooksValidator.validateReadBookcategory("");
        });
    }
}
