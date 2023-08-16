package livre.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import livre.model.Readbooks;
import livre.services.ReadbooksService;
import livre.services.exceptions.ServiceException;

public class TestAddbooksFeature {
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


// null value 
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

// invalid book name 

@Test
public void testInavlidBookName() {
	ReadbooksService readbooksService = new ReadbooksService();
    Readbooks readbooks = new Readbooks(1, "1D@rk", "imagelink-url", "pdf-link-url", "TRILLER");
	
	try {
		assertTrue(readbooksService.AddReadBooks(readbooks));
	}catch(ServiceException e){
		e.printStackTrace();
		fail();
	}
}

// invalid category

@Test
public void testInValidCategory() {
	ReadbooksService readbooksService = new ReadbooksService();
    Readbooks readbooks = new Readbooks(1, "you", "imagelink-url", "pdf-link-url", "WOw");
	
	try {
		assertTrue(readbooksService.AddReadBooks(readbooks));
	}catch(ServiceException e){
		e.printStackTrace();
		fail();
	}
}


}


