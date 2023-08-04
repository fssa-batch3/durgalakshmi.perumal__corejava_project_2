package livre.validation;

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
	
	public static boolean validLogin(String email, String password) throws InvalidUserException{
		if(email != null && password != null && validateEmail(email) && validatePassword(password) ) {
			return true;
		}
		else {
			throw new InvalidUserException("Invalid login user details");
		}
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
