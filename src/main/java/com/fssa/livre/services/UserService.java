package com.fssa.livre.services;

import java.util.List;

import com.fssa.livre.dao.UserDAO;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.User;
import com.fssa.livre.services.exceptions.ServiceException;
import com.fssa.livre.validation.UserValidator;
import com.fssa.livre.validation.exceptions.InvalidUserException;

public class UserService {

    /**
     * Registers a new user.
     *
     * @param user,The user to be registered.
     * @return True if the user is registered successfully, false otherwise.
     * @throws ServiceException If an error occurs while validating or registering the user.
     */
    public static boolean registerUser(User user) throws ServiceException {
        UserDAO userDAO = new UserDAO();
        try {
            UserValidator.validUser(user); 
            if (userDAO.register(user)) {
                return true;
            } else {
                return false;
            }
        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }
 
    
    public static User getUserByEmail(String email) throws ServiceException {
        try {
            return UserDAO.getUserByEmail(email);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    public int getUserIdByEmail(String email) throws ServiceException, DAOException {
        try {
			return UserDAO.getUserIdByEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }


    public void updateUserProfile(User user) throws ServiceException {
        try {
            // You can add validation here if needed before calling the DAO
            UserDAO.updateUserProfile(user);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    public User getUserById(int userId) throws ServiceException {
        try {
            User user = UserDAO.getUserById(userId);

            if (user != null) {
                // User found, you can perform additional operations if needed
                return user;
            } else {
                throw new ServiceException("User not found");
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
    

//    public boolean updateUserDetailsByEmail(String email, String firstname, String lastname, int phoneNumber, int age) throws ServiceException, InvalidUserException {
//        try {
//            if (UserValidator.validateUpdateUserDetails(firstname, lastname, phoneNumber, age)) {
//                return UserDAO.updateUserDetailsByEmail(email, firstname, lastname, phoneNumber, age);
//            } else {
//                return false; // Validation failed
//            }
//        } catch (DAOException e) {
//            throw new ServiceException(e);
//        }
//    }


    /**
     * Authenticates a user during login.
     *
     * @param email, The email of the user.
     * @param password The password of the user.
     * @return True if the login credentials are valid, false otherwise.
     * @throws ServiceException If an error occurs while validating the login credentials.
     */
    public boolean loginUser(String email, String password) throws ServiceException {
        try {
            return UserValidator.validateLogin(email, password);
        } catch (InvalidUserException e) {
            throw new ServiceException(e);
        }
    }
     
    /**
     * @return
     * @throws ServiceException
     */
    public List<User> getAllUserList() throws ServiceException{
    	try {
			return UserDAO.getAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
    }


	
}
