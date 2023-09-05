package com.fssa.livre.validation;
import java.util.regex.Matcher;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.fssa.livre.model.Readbooks;
import com.fssa.livre.validation.exceptions.InvalidBooksException;
import com.fssa.livre.validation.exceptions.InvalidUserException;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;




public class ReadbooksValidator {

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
				&& ValidateReadBookcategory(readbooks.getCategory()) && validateReadBookImage(readbooks.getImagelink()) && validateId(readbooks.getReadbookid()) && validateReadBookPdf(readbooks.getPdflink()) ;
		
	}
	
	public static boolean validRbooks(Readbooks readbooks) throws InvalidBooksException {
		return readbooks != null && validateReadBookName(readbooks.getBookname())
				&& ValidateReadBookcategory(readbooks.getCategory()) && validateReadBookImage(readbooks.getImagelink())  && validateReadBookPdf(readbooks.getPdflink()) ;
		
	}

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

	    String regex = "^[A-Za-z0-9\\s]+$";  // Allow alphabetic characters, numeric characters, and spaces
	    if (!trimmedBookName.matches(regex)) {
	        throw new InvalidBooksException("The book name can only contain alphabetic characters, numeric characters, and spaces");
	    }

	    return true;
	}

	/**
	 * @param pdfurl
	 * @return
	 * @throws InvalidBooksException
	 */
	public static boolean validateReadBookPdf(String pdfurl) throws InvalidBooksException {
		if (pdfurl == null)
			throw new InvalidBooksException("The book pdf url should not be null");
		if (pdfurl.trim().isEmpty()) {
			throw new InvalidBooksException("The book pdf url is should not be empty");
	}
		return true;
	}
	/**
	 * @param url
	 * @return
	 * @throws InvalidBooksException
	 */
	public static boolean validateReadBookImage(String url) throws InvalidBooksException {
		if (url == null)
			throw new InvalidBooksException("The book url should not be null");
		if (url.trim().isEmpty()) {
			throw new InvalidBooksException("The book url is should not be empty");
	}
		return true;
	}
	/**
	 * Validates a book category based on predefined categories.
	 *
	 * @param category The book category to be validated.
	 * @return True if the book category is valid, false otherwise.
	 */
	public static boolean ValidateReadBookcategory(String category) throws InvalidBooksException {

		if (category == null)
			throw new InvalidBooksException("The book name should not be null");
		if (category.trim().isEmpty()) {
			throw new InvalidBooksException("The book name is should not be empty");
		}
		String bookcategory = category.trim().toUpperCase();
		if ("ADVENTURETRILLERROMANTICCOMEDYCLASSICHORRORDEVOTIONAL".contains(bookcategory)) {
			return true;
		} else {
			throw new InvalidBooksException("The book category must be adventure|triller|romantic|comedy|classic|horror|devotional");
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
			System.out.println("The book ID is valid");
		return true;
		} else  {
			System.out.println("The book ID is Invalid");
			throw new InvalidBooksException("The book ID should not be 0 and lesser than 0");
		}

	}
}
