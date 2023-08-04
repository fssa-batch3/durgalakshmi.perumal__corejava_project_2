package livre.validations;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import livre.model.Readbooks;
import livre.services.ReadbooksService;
import livre.services.exceptions.ServiceException;

public class TestUpadteReadbooks {
    @Test
    public void testCreateProductAndThenUpdate() {
        ReadbooksService readbooksService = new ReadbooksService();

        // Create a new book without specifying the readbook_id
        Readbooks newBook = new Readbooks(0, "dump", "imagelink-url", "pdf-link-url", "TRILLER");

        try {
            // Add the new book to the database and get its assigned readbook_id
            int newBookId = readbooksService.AddReadBooks(newBook);

            // Set the readbook_id returned by the service in the book object
            newBook.setReadbookId(newBookId);

            // Now, modify some properties of the book
            newBook.setImagelink("new-image-link-url");
            newBook.setImagelink("new-pdf-link-url");
            newBook.setCategory("MYSTERY");

            // Call the update method to update the book
            assertTrue(readbooksService.updateReadBooks(newBook));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }
}

