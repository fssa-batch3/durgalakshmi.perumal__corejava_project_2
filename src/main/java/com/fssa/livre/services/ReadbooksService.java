package com.fssa.livre.services;
import java.util.List;
import com.fssa.livre.dao.ReadbooksDAO;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.Readbooks;
import com.fssa.livre.services.exceptions.ServiceException;
import com.fssa.livre.validation.ReadbooksValidator;
import com.fssa.livre.validation.exceptions.InvalidBooksException;

public class ReadbooksService { 



    /** 
     * Adds a new readbook to the database.
     *
     * @param The readbook to be added.
     * @return True if the readbook is added successfully, false otherwise.
     * @throws ServiceException If an error occurs while validating or adding the readbook.
     * @throws  
     */
    public boolean addReadBooks(Readbooks readbooks) throws ServiceException  {
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
        } catch (InvalidBooksException | DAOException e) {
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
    public boolean readbooksUpdate(Readbooks readbooks) throws ServiceException {
    	 ReadbooksDAO Readbooks = new ReadbooksDAO();
        try {
            ReadbooksValidator.validEditRbooks(readbooks);
            if (Readbooks.updateBooks(readbooks)) {
                System.out.println("ReadBooks " + readbooks.getBookname() + " Successfully Updated");
                return true;
            } else {
                System.out.println("ReadBooks " + readbooks.getBookname() + " Not Updated");
                return false;
            }
        } catch (InvalidBooksException | DAOException  e) {
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
    public static boolean ReadbooksDelete(int id) throws ServiceException {
        ReadbooksDAO DeleteBooks = new ReadbooksDAO();
        try {
            ReadbooksValidator.validateId(id);
            if (DeleteBooks.deleteBooks(id)) {
                System.out.println("Product ID no " + id + " deleted Successfully");
                return true;
            } else {
                System.out.println("Product ID no " + id + " unable to delete");
                return false;
            }
        } catch (InvalidBooksException | DAOException e) {
            throw new ServiceException(e);
        }
    }
    
    
    /**
     * Searches for readbooks by category and returns a list of matching readbooks.
     *
     * @param category The category to search for readbooks.
     * @return A list of matching readbooks.
     * @throws ServiceException If an error occurs during the search process.
     */
    public List<Readbooks> searchReadbooksByCategory(String category) throws ServiceException {
        try {
          
            List<Readbooks> searchResults = ReadbooksDAO.searchReadbooksByCategory(category); 

            if (searchResults.isEmpty()) {
                System.out.println("No readbooks found for the selected category");
            } else {
                System.out.println("Found " + searchResults.size() + " readbooks for the selected category");
            }

            return searchResults;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    } 

    
    
    /**
     * 
     * @return
     * @throws ServiceException
     */
    public List<Readbooks> getAllReadbooks() throws ServiceException {
        try {
            return ReadbooksDAO.getAllReadbooks(); // Assuming ReadbooksDAO.getAllReadbooks() returns List<Readbooks>
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
