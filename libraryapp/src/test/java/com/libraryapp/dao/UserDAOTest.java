package com.libraryapp.dao;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserDAOTest {
    private UserDAO userDAO;

    @Before
    public void setUp() {
        this.userDAO = new UserDAO();
    }

    @Test
    public void testCreateUser() {
        assertTrue(this.userDAO.createUser("John Smith", "jsmith", "password"));
    }
}
