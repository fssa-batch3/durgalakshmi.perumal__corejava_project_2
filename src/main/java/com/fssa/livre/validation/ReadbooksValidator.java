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
		return readbooks != null && ValidateReadBookName(readbooks.getBookname())
				&& ValidateReadBookcategory(readbooks.getCategory()) && validateReadBookImage(readbooks.getImagelink()) && validateId(readbooks.getReadbook_id()) && validateReadBookPdf(readbooks.getPdflink()) ;
		
	}
	
	public static boolean validRbooks(Readbooks readbooks) throws InvalidBooksException {
		return readbooks != null && ValidateReadBookName(readbooks.getBookname())
				&& ValidateReadBookcategory(readbooks.getCategory()) && validateReadBookImage(readbooks.getImagelink())  && validateReadBookPdf(readbooks.getPdflink()) ;
		
	}

	/**
	 * Validates a book name using a regular expression pattern.
	 *
	 * @param bookname The book name to be validated.
	 * @return True if the book name is valid, false otherwise.
	 */
	public static boolean ValidateReadBookName(String bookname) throws InvalidBooksException {

		if (bookname == null)
			throw new InvalidBooksException("The book name should not be null");
		if (bookname.trim().isEmpty()) {
			throw new InvalidBooksException("The book name is should not be empty");
		}

		String regex = "^[A-Z a-z]{3,29}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(bookname);
		boolean match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidBooksException(
					"The book name can contain alphabetic values or numeric values and spaces");
		}

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
