package livre.validation;
import livre.dao.*;
import livre.dao.excepion.DAOException;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import livre.model.User;
import livre.validation.exceptions.InvalidUserException;

public class UserValidator {
	public static boolean validUser(User user)throws InvalidUserException{
		if(user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword()) ) {
			return true;
		}
		else {
			throw new InvalidUserException("User details is invalid");
		}
	}
	//login
	public static boolean validateLogin(String email, String password) throws InvalidUserException{
		UserDAO userDAO = new UserDAO(); 
		
		 if (validateEmail(email) && validatePassword(password)) {
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
		 return false;
		}
	
	
	public static boolean validatePassword(String password) {
		boolean match = false;
		if(password == null)
			return false;
		try {
//			String pattern_string = "(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?= \\S+$).{8,}";
//			String pattern_string = "(?=.*[0-9])(?=.*[A-Z])(?=\\S+$).{8,}";
			String pattern_string = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
			match = Pattern.matches(pattern_string, password);
//			boolean match = pattern.matches(password);
//			Pattern pattern = Pattern.compile(pattern_string);
//			Matcher m = pattern.matcher(password);
			if (match) {
//			if (m.matches()) {
				System.out.println("Valid password.");
			} else {
				System.out.println("Invalid password."); 
			}
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		return match;
	}
	
	

	public static boolean validateEmail(String email) {
		boolean isMatch = false;
		if(email == null)
			return false;
		try {
			String regex = "^.*@.*\\..*$";
			isMatch = Pattern.matches(regex, email);
			if (isMatch) {
				System.out.println("The email address is: Valid");
			} else {
				System.out.println("The email address is: Invalid");
			}
			return isMatch;
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		return isMatch;
	}
}
