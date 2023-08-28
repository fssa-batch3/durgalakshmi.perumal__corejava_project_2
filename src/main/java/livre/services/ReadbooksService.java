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

    /**
     * Adds a new readbook to the database.
     *
     * @param readbooks The readbook to be added.
     * @return True if the readbook is added successfully, false otherwise.
     * @throws ServiceException If an error occurs while validating or adding the readbook.
     */
    public boolean AddReadBooks(Readbooks readbooks) throws ServiceException {
        ReadbooksDAO Readbooks = new ReadbooksDAO();
        try {
            ReadbooksValidator.validRbooks(readbooks);
            if (Readbooks.addReadBooks(readbooks)) {
                System.out.println("Successfully added book");
                return true;
            } else {
                System.out.println("Book is not added");
                return false;
            }
        } catch (DAOException | InvalidUserException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Updates a readbook in the database.
     *
     * @param readbooks The updated readbook information.
     * @return True if the readbook is updated successfully, false otherwise.
     * @throws ServiceException If an error occurs while validating or updating the readbook.
     */
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

    /**
     * Deletes a readbook from the database by its ID.
     *
     * @param id The ID of the readbook to be deleted.
     * @return True if the readbook is deleted successfully, false otherwise.
     * @throws ServiceException If an error occurs while validating or deleting the readbook.
     */
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
