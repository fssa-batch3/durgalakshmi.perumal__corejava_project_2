package livre.services;

import livre.validation.*;
import livre.validation.exceptions.InvalidUserException;
import livre.dao.*;
import livre.dao.excepion.DAOException;
import livre.model.User;
import livre.services.exceptions.ServiceException;

public class UserService {
	
	//for register
	public boolean registerUser(User user) throws ServiceException {

		UserDAO userDAO = new UserDAO();
		try {
			UserValidator.validUser(user);
			if (userDAO.register(user)) {
				System.out.println(user.getEmail() + " successfully added");
				return true;
			} else {
				System.out.println("Registration not successful");
				return false;
			} 

		} catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	//for login
	
	public boolean loginUser(String email , String password) throws ServiceException {
		
		UserDAO userDAO = new UserDAO();
		
		try {
			UserValidator.validLogin(email , password);
			if (userDAO.login(email , password)) {
				System.out.println(email + " successfully logged in ");
				return true;}
			else {
				System.out.println("Logging in is not successful");
				return false;
			}
			
		}catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}
	
	
}
