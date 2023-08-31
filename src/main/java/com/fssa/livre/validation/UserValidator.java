package com.fssa.livre.validation;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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
    public static boolean validUser(User user) throws InvalidUserException {
        if (user != null && validateEmail(user.getEmail()) && validatePassword(user.getPassword())) {
            return true;
        } else {
            throw new InvalidUserException("User details are invalid");
        }
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

    /**
     * Validates a password using a regular expression pattern.
     *
     * @param password The password to be validated.
     * @return True if the password is valid, false otherwise.
     */
    public static boolean validatePassword(String password) {
        boolean match = false;
        if (password == null)
            return false;
        try {

            String pattern_string = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
            match = Pattern.matches(pattern_string, password);

            if (match) {
                System.out.println("Valid password.");
            } else {
                System.out.println("Invalid password.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println(e.getMessage());
        }
        return match;
    }

    /**
     * Validates an email address using a regular expression pattern.
     *
     * @param email The email address to be validated.
     * @return True if the email address is valid, false otherwise.
     */
    public static boolean validateEmail(String email) {
        boolean isMatch = false;
        if (email == null)
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

