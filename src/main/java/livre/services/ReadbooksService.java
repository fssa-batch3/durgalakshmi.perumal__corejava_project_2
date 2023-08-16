package livre.services;
import livre.model.Readbooks;
import livre.services.exceptions.ServiceException;

import java.util.function.BooleanSupplier;

import livre.dao.ReadbooksDAO;
import livre.dao.excepion.DAOException;
import livre.validation.ReadbooksValidator;
import livre.validation.exceptions.InvalidUserException;


public class ReadbooksService {
	
	   private ReadbooksDAO readbooksDAO;

	    public ReadbooksService() {
	        readbooksDAO = new ReadbooksDAO();
	    }
	public boolean AddReadBooks (Readbooks readbooks) throws ServiceException {
		ReadbooksDAO Readbooks = new ReadbooksDAO(); 
		try {
			ReadbooksValidator.validRbooks(readbooks);
			if (Readbooks.ReadBooks(readbooks)) {
				System.out.println("successfully added book");
				return true;}
			else {
				System.out.println("Book is not added");
				return false;
			}
		}catch (DAOException | InvalidUserException e) {
			throw new ServiceException(e);
		}
	}

	public boolean ReadbooksUpdate(Readbooks readbooks) throws ServiceException {
	    try {
	        ReadbooksValidator.validRbooks(readbooks);
	        if (readbooksDAO.updateBooks(readbooks)) {
	            System.out.println("ReadBooks " + readbooks.getBookname() + " Successfully Updated");
	            return true;
	        } else {
	            System.out.println("ReadBooks " + readbooks.getBookname() + " Updating not successful");
	            return false;
	        }
	    } catch (DAOException | InvalidUserException e) {
	        throw new ServiceException(e);
	    }
	}




public boolean ReadbooksDelete(int id) throws ServiceException {
	ReadbooksDAO DeleteBooks = new ReadbooksDAO();
	try {
		ReadbooksValidator.validateId(id);
		if (ReadbooksDAO.DeleteBooks(id)) {
			System.out.println("Product ID no " + id + " deleted Successfully");
			return true;
		} else {
			System.out.println("Product ID no " + id + " unable to delete");
			return false;
		}
	} catch (DAOException e) {
		throw new ServiceException(e);
	}
}

}

