package livre.validation;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import livre.model.Readbooks;

import livre.validation.exceptions.InvalidUserException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ReadbooksValidator {

    /**
     * Validates the details of a Readbooks object.
     *
     * @param readbooks The Readbooks object to be validated.
     * @return True if the Readbooks details are valid, false otherwise.
     * @throws InvalidUserException If the Readbooks details are invalid.
     */
    public static boolean validRbooks(Readbooks readbooks) throws InvalidUserException {
        if (readbooks != null && ValidateReadBookName(readbooks.getBookname()) && ValidateReadBookcategory(readbooks.getCategory())) {
            return true;
        } else {
            throw new InvalidUserException("Readbooks details are invalid");
        }
    }

    /**
     * Validates a book name using a regular expression pattern.
     *
     * @param bookname The book name to be validated.
     * @return True if the book name is valid, false otherwise.
     */
    public static boolean ValidateReadBookName(String bookname) {
        boolean isMatch = false;
        if (bookname == null)
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

    /**
     * Validates a book category based on predefined categories.
     *
     * @param category The book category to be validated.
     * @return True if the book category is valid, false otherwise.
     */
    public static boolean ValidateReadBookcategory(String category) {
        boolean isMatch = false;
        if (category == null)
            return false;
        try {
            String Category = "ADVENTURETRILLERROMANTICCOMEDYCLASSICHORRORDEVOTIONAL";

            if (Category.contains(category)) {
                System.out.println("The category is: Valid");
                isMatch = true;
            } else {
                System.out.println("The category is: Invalid");
            }
            return isMatch;
        } catch (PatternSyntaxException e) {
            System.out.println(e.getMessage());
        }
        return isMatch;
    }

    /**
     * Validates a book ID to ensure it is positive.
     *
     * @param id The book ID to be validated.
     * @return True if the book ID is valid, false otherwise.
     */
    public static boolean validateId(int id) {
        boolean match = true;
        if (id > 0) {
            System.out.println("The ID is valid");
            match = true;
        } else if (id <= 0) {
            System.out.println("The ID is Invalid");
            match = false;
        }
        return match;
    }
}
