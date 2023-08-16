package livre.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import livre.model.Readbooks;
import livre.services.ReadbooksService;
import livre.services.exceptions.ServiceException;

public class TestUpadteReadbooks {

    
    
    @Test
    public void testValidUpdate() {
    	ReadbooksService readbooksService = new ReadbooksService();
    	Readbooks readbooks = new Readbooks(30, "you", "imagelink-url", "pdf-link-url", "TRILLER");
    	try {
    		assertTrue(readbooksService.ReadbooksUpdate(readbooks));
    	}catch(ServiceException e){
    		e.printStackTrace();
    		fail();
    	}
    }

 
 
    
    @Test
    public void testInValidUpdate() {
        ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks(40, "dump", "imagelink-url", "pdf-link-url", "TRILLER");
        try {
    		assertTrue(readbooksService.ReadbooksUpdate(readbooks));
    	}catch(ServiceException e){
    		e.printStackTrace();
    		fail();
    	}
    }

    //null value
    
    @Test
    public void testNullValue() {
        ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks();
        try {
    		assertTrue(readbooksService.ReadbooksUpdate(readbooks));
    	}catch(ServiceException e){
    		e.printStackTrace();
    		fail();
    	}
    }
    
    
    // invalid book name 
    
    @Test
    public void testInavlidBookName() {
        ReadbooksService readbooksService = new ReadbooksService();
        Readbooks readbooks = new Readbooks(40, "dum@hh", "imagelink-url", "pdf-link-url", "TRILLER");
        try {
    		assertTrue(readbooksService.ReadbooksUpdate(readbooks));
    	}catch(ServiceException e){
    		e.printStackTrace();
    		fail();
    	}
    }
}


