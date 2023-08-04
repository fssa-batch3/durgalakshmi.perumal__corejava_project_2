package livre.validations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import livre.model.Readbooks;
import livre.services.ReadbooksService;
import livre.services.exceptions.ServiceException;

public class TestReadbooksFeature {
@Test
	public void testCreateProduct() {
		ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks(0, "moon", "imagelink-url", "pdf-link-url", "TRILLER");
		
		try {
			assertTrue(readbooksService.AddReadBooks(readbooks));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}



}


