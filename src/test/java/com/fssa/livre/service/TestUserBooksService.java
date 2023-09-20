package com.fssa.livre.service;
import java.util.ArrayList;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fssa.livre.dao.UserBooksDAO;
import com.fssa.livre.dao.exception.DAOException;
import com.fssa.livre.model.UserBooks;
import com.fssa.livre.services.ReadbooksService;
import com.fssa.livre.services.UserBooksService;
import com.fssa.livre.validation.exceptions.InvalidBooksException;
import com.google.protobuf.ServiceException;

public class TestUserBooksService {
	

    @Test
    void testAddUserBook() {
        UserBooksService userBooksService = new UserBooksService();
        UserBooks userBook = new UserBooks(1, 1, 1, true);

        try {
            assertTrue(userBooksService.addUserBook(userBook));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }
    

}
