package livre.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import livre.model.Readbooks;
import livre.services.ReadbooksService;
import livre.services.exceptions.ServiceException;

public class TestReadbooksFeature {
@Test
	public void testCreateProduct() {
		ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks(1, "you", "imagelink-url", "pdf-link-url", "TRILLER");
		
		try {
			assertTrue(readbooksService.AddReadBooks(readbooks));
		}catch(ServiceException e){
			e.printStackTrace();
			fail();
		}
	}
@Test
public void testNullProduct() { 
	ReadbooksService productService = new ReadbooksService();
	Readbooks product = null;
	try {
		assertFalse(productService.AddReadBooks(product));
	} catch (ServiceException e) {
		e.printStackTrace();
	}
}


}


