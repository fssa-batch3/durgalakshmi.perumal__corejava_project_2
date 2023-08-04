package livre.services;
import livre.model.Readbooks;
import livre.services.exceptions.ServiceException;
import livre.dao.ReadbooksDAO;
import livre.dao.excepion.DAOException;
import livre.validation.ReadbooksValidator;
import livre.validation.exceptions.InvalidUserException;


public class ReadbooksService {
	public boolean AddReadBooks (Readbooks readbooks) throws ServiceException {
		ReadbooksDAO Readbooks = new ReadbooksDAO(); 
		try {
			ReadbooksValidator.validRbooks(readbooks);
			if (Readbooks.READBOOKS(readbooks)) {
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

public String updateReadBooks(Readbooks readbooks) throws ServiceException {
    ReadbooksDAO readbooksDAO = new ReadbooksDAO();

    try {
        ReadbooksValidator.validRbooks(readbooks);
        if (readbooksDAO.updateBooks(readbooks)) {
            return "Successfully updated book.";
        } else {
            return "Book update failed or the book doesn't exist.";
        }
    } catch (DAOException | InvalidUserException e) {
        throw new ServiceException(e);
    }
}}