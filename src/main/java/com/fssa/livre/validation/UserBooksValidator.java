package com.fssa.livre.validation;

import com.fssa.livre.model.UserBooks;
import com.fssa.livre.validation.exceptions.InvalidUserException;

public class UserBooksValidator {

    /**
     * Validates a user book ID to ensure it is positive.
     *
     * @param userBookId The user book ID to be validated.
     * @return True if the user book ID is valid, false otherwise.
     * @throws InvalidUserException If the user book ID is invalid.
     */
    public static boolean validateUserBookId(int userBookId) throws InvalidUserException {
        if (userBookId > 0) {
            return true;
        } else {
            throw new InvalidUserException("The user book ID should be greater than 0");
        }
    }

    /**
     * Validates a user ID to ensure it is positive.
     *
     * @param userId The user ID to be validated.
     * @return True if the user ID is valid, false otherwise.
     * @throws InvalidUserException If the user ID is invalid.
     */
    public static boolean validateUserId(int userId) throws InvalidUserException {
        if (userId > 0) {
            return true;
        } else {
            throw new InvalidUserException("The user ID should be greater than 0");
        }
    }

    /**
     * Validates a read book ID to ensure it is positive.
     *
     * @param readBookId The read book ID to be validated.
     * @return True if the read book ID is valid, false otherwise.
     * @throws InvalidUserException If the read book ID is invalid.
     */
    public static boolean validateReadBookId(int readBookId) throws InvalidUserException {
        if (readBookId > 0) {
            return true;
        } else {
            throw new InvalidUserException("The read book ID should be greater than 0");
        }
    }

    /**
     * Validates the status of a user book.
     *
     * @param status The status of the user book to be validated.
     * @return True if the status is valid, false otherwise.
     * @throws InvalidUserException If the status is invalid.
     */
    public static boolean validateStatus(Boolean status) throws InvalidUserException {
        if (status != null) {
            return true;
        } else {
            throw new InvalidUserException("The status should not be null");
        }
    }

    /**
     * Validates the details of a UserBooks object.
     *
     * @param userBooks The UserBooks object to be validated.
     * @return True if the UserBooks details are valid, false otherwise.
     * @throws InvalidUserException If the UserBooks details are invalid.
     */
    public static boolean validateUserBooks(UserBooks userBooks) throws InvalidUserException {
        return userBooks != null &&
                validateUserBookId(userBooks.getUserBookId()) &&
                validateUserId(userBooks.getUserId()) &&
                validateReadBookId(userBooks.getReadBookId()) &&
                validateStatus(userBooks.isStatus());
    }
}
