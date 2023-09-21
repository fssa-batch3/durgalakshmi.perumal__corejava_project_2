package com.fssa.livre.validation;

import java.util.regex.Pattern;
import com.fssa.livre.dao.*;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.User;
import com.fssa.livre.validation.exceptions.InvalidUserException;

public class UserValidator {

	/**
	 * Validates the details of a User object.
	 *
	 * @param user The User object to be validated.
	 * @return True if the User details are valid, false otherwise.
	 * @throws InvalidUserException If the User details are invalid.
	 */
	@SuppressWarnings("null")
	public static boolean validUser(User user) throws InvalidUserException {
		if (user == null)
			throw new InvalidUserException("User details are invalid");
		
		 validateEmail(user.getEmail());
		 return validatePassword(user.getPassword()); 
	}

	/**
	 * Validates the login details of a user.
	 *
	 * @param email    The user's email.
	 * @param password The user's password.
	 * @return True if the login details are valid, false otherwise.
	 * @throws InvalidUserException If the login details are invalid.
	 */
	public static boolean validateLogin(String email, String password) throws InvalidUserException {
		UserDAO userDAO = new UserDAO();

		validateEmail(email); 
		validatePassword(password);
			try {
				User storedUser = userDAO.getUserByEmail(email);

				if (storedUser != null) {
					if (storedUser.getPassword().equals(password)) {
						return true;
					} else {
						throw new InvalidUserException("Invalid password");
					}
				} else {
					throw new InvalidUserException("User not found");
				}
			} catch (DAOException e) {
				throw new InvalidUserException("Invalid login user details");
			}

	}

	/**
	 * Validates a password using a regular expression pattern.
	 *
	 * @param password The password to be validated.
	 * @return True if the password is valid, false otherwise.
	 * @throws InvalidUserException
	 */
	public static boolean validatePassword(String password) throws InvalidUserException {

		if (password == null)
			throw new InvalidUserException("password should not be null");
		if(password.trim().isEmpty())
			throw new InvalidUserException("password should not be empty");

		String passwordstring = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		boolean match = Pattern.matches(passwordstring, password);

		if (match) {
			return true;
		} else {
			throw new InvalidUserException(
					"Invalid password - The password should contain at least one capital letter, one small letter, one special character, one number, and have a minimum length of 6 characters.");
		}
	}

	/**
	 * Validates an email address using a regular expression pattern.
	 *
	 * @param email The email address to be validated.
	 * @return True if the email address is valid, false otherwise.
	 * @throws InvalidUserException 
	 */
	public static boolean validateEmail(String email) throws InvalidUserException {
		if (email == null)
		 throw new InvalidUserException("email should not be null");
		if(email.trim().isEmpty())
		 throw new InvalidUserException("email should not be empty");
	
			String regex = "^.*@.*\\..*$";
			boolean isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				return true;
			} else {
				throw new InvalidUserException("The email address you provided is invalid. Please make sure it follows the correct format (e.g., example@email.com).");
			}

		} 

	

public static boolean validateAge(int age) throws InvalidUserException {
    if (age < 18 || age > 100) {
        throw new InvalidUserException("Age should be between 18 and 100.");
    }
    
    return true;
}

public static boolean validatePhoneNumber(int phoneNumber) throws InvalidUserException {
    String phoneNumberStr = String.valueOf(phoneNumber);
    
    if (phoneNumberStr.length() != 10) {
        throw new InvalidUserException("Phone number should have exactly 10 digits.");
    }
    
    char firstDigit = phoneNumberStr.charAt(0);
    
    if (firstDigit != '8' && firstDigit != '6' && firstDigit != '7' && firstDigit != '9') {
        throw new InvalidUserException("Phone number should start with 8, 6, 7, or 9.");
    }
    
    return true;
}

public static boolean validateFirstName(String firstname) throws InvalidUserException {
    if (firstname == null) {
        throw new InvalidUserException("Name should not be null.");
    }
    
    if (firstname.trim().isEmpty()) {
        throw new InvalidUserException("Name should not be empty.");
    }

    if (!firstname.matches("^[a-zA-Z]*$")) {
        throw new InvalidUserException("Name should only contain alphabetic characters.");
    }
    
    return true;
}


public static boolean validateLastName(String lastname) throws InvalidUserException {
    if (lastname == null) {
        throw new InvalidUserException("Name should not be null.");
    }
    
    if (lastname.trim().isEmpty()) {
        throw new InvalidUserException("Name should not be empty.");
    }

    if (!lastname.matches("^[a-zA-Z]*$")) {
        throw new InvalidUserException("Name should only contain alphabetic characters.");
    }
    
    return true;
}
	
public static boolean validateUpdateUserDetails(String firstname, String lastname, int phoneNumber, int age) throws InvalidUserException {
    if (validateFirstName(firstname) && validateLastName(lastname) && validateAge(age) && validatePhoneNumber(phoneNumber)) {
        return true;
    } else {
        return false;
    }
}

	}

