package com.fssa.livre.validation;

import com.fssa.livre.model.Readbooks;
import com.fssa.livre.validation.exceptions.InvalidBooksException;
import com.fssa.livre.validation.exceptions.InvalidUserException;


public class ReadbooksValidator {

	/**
	 * Validates a book name using a regular expression pattern.
	 *
	 * @param bookname The book name to be validated.
	 * @return True if the book name is valid, false otherwise.
	 */

	public static boolean validateReadBookName(String bookname) throws InvalidBooksException {
	    if (bookname == null) {
	        throw new InvalidBooksException("The book name should not be null");
	    }
	    
	    String trimmedBookName = bookname.trim();
	    if (trimmedBookName.isEmpty()) {
	        throw new InvalidBooksException("The book name should not be empty");
	    }

	    String regex = "^[A-Za-z0-9\\s]+$"; 
	    if (!trimmedBookName.matches(regex)) {
	        throw new InvalidBooksException("The book name can only contain alphabetic characters, numeric characters, and spaces");
	    }

	    return true;
	}

	/**
	 * Validates a book PDF URL with the "https" protocol.
	 *
	 * @param pdfurl The book PDF URL to be validated.
	 * @return True if the URL is valid, false otherwise.
	 * @throws InvalidBooksException if the URL is null or empty, or if it does not start with "https://".
	 */
	public static boolean validateReadBookPdf(String pdfurl) throws InvalidBooksException {
	    if (pdfurl == null) {
	        throw new InvalidBooksException("The book PDF URL should not be null");
	    }

	    String trimmedUrl = pdfurl.trim();

	    if (trimmedUrl.isEmpty()) {
	        throw new InvalidBooksException("The book PDF URL should not be empty");
	    }

	    return true;
	}


	
	/**
	 * Validates a book image URL with the "https" protocol.
	 *
	 * @param url The book image URL to be validated.
	 * @return True if the URL is valid, false otherwise.
	 * @throws InvalidBooksException if the URL is null, empty, or has an invalid format.
	 */
	public static boolean validateReadBookImage(String url) throws InvalidBooksException {
	    if (url == null) {
	        throw new InvalidBooksException("The book URL should not be null");
	    }
	    
	    String trimmedUrl = url.trim();
	    
	    if (trimmedUrl.isEmpty()) {
	        throw new InvalidBooksException("The book URL should not be empty");
	    }
	    
	    if (!trimmedUrl.startsWith("https://")) {
	        throw new InvalidBooksException("Invalid book URL format. It should start with 'https://'.");
	    }
	    
	    return true;
	}

	/**
	 * Validates a book category based on predefined categories.
	 *
	 * @param category The book category to be validated.
	 * @return True if the book category is valid, false otherwise.
	 */
	public static boolean validateReadBookcategory(String category) throws InvalidBooksException {

		if (category == null)
			throw new InvalidBooksException("The book name should not be null");
		if (category.trim().isEmpty()) {
			throw new InvalidBooksException("The book name is should not be empty");
		}
		String bookcategory = category.trim().toUpperCase();
		if ("ADVENTURETHRILLERROMANTICCOMEDYCLASSICHORRORDEVOTIONAL".contains(bookcategory)) {
			return true;
		} else {
			throw new InvalidBooksException("The book category must be adventure|thriller|romantic|comedy|classic|horror|devotional");
		}

	}

	/**
	 * Validates a book ID to ensure it is positive.
	 *
	 * @param id The book ID to be validated.
	 * @return True if the book ID is valid, false otherwise.
	 */
	public static boolean validateId(int id) throws InvalidBooksException { 

		if (id > 0) {
		return true;
		} else  {
		
			throw new InvalidBooksException("The book ID should not be 0 and lesser than 0");
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Validates the details of a Readbooks object.
	 *
	 * @param readbooks The Readbooks object to be validated.
	 * @return True if the Readbooks details are valid, false otherwise.
	 * @throws InvalidUserException  If the Readbooks details are invalid.
	 * @throws InvalidBooksException
	 */
	public static boolean validEditRbooks(Readbooks readbooks) throws InvalidBooksException {
		return readbooks != null && validateReadBookName(readbooks.getBookname())
				&& validateReadBookcategory(readbooks.getCategory()) && validateReadBookImage(readbooks.getImagelink()) && validateId(readbooks.getReadbookid()) && validateReadBookPdf(readbooks.getPdflink()) ;
		
	}
	
	public static boolean validRbooks(Readbooks readbooks) throws InvalidBooksException {
		return readbooks != null && validateReadBookName(readbooks.getBookname())
				&& validateReadBookcategory(readbooks.getCategory()) && validateReadBookImage(readbooks.getImagelink())  && validateReadBookPdf(readbooks.getPdflink()) ;
		
	}
}
