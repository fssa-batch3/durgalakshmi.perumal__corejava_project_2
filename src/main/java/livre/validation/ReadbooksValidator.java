package livre.validation;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import livre.model.Readbooks;

import livre.validation.exceptions.InvalidUserException;

public class ReadbooksValidator {
	public static boolean validRbooks(Readbooks  readbooks)throws InvalidUserException{
		if(readbooks != null && ValidateReadBookName(readbooks.getBookname()) && ValidateReadBookcategory(readbooks.getCategory()) ) {
			return true;
		}
		else {
			throw new InvalidUserException("User details is invalid");
		}
	}

	public static boolean ValidateReadBookName(String bookname) {
		boolean isMatch = false;
		if(bookname == null)
			return false;
		try {
			String regex = "^[A-Z a-z]{3,29}$";
			isMatch = Pattern.matches(regex, bookname);
			if (isMatch) {
				System.out.println("The Name is: Valid");
			} else {
				System.out.println("The Name is: Invalid");
			}
			return isMatch;
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		return isMatch;
	}
	
	
	
	public static boolean ValidateReadBookcategory(String category) {
		boolean isMatch = false;
		if(category == null)
			return false;
		try {
			String Category = "ADVENTURETRILLERROMANTICCOMEDYCLASSICHORRORDEVOTIONAL";
			
			if (Category.contains(Category)) {
				System.out.println("The category is: Valid");
				isMatch= true;
			} else {
				System.out.println("The category is: Invalid");
			}
			return isMatch;
		} catch (PatternSyntaxException e) {
			System.out.println(e.getMessage());
		}
		return isMatch;
	}
}
