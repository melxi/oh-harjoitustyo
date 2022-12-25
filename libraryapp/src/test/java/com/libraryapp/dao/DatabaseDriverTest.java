package com.libraryapp.dao;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DatabaseDriverTest {
    private final DatabaseDriver databaseDriver = new DatabaseDriver();

    @Test
    public void testCreateUsersTable() throws Exception {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='users';";
        Statement statement = databaseDriver.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        assertTrue(resultSet.next());
    }

    @Test
    public void testCreateAuthorsTable() throws Exception {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='authors';";
        Statement statement = databaseDriver.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        assertTrue(resultSet.next());
    }

    @Test
    public void testCreateBooksTable() throws Exception {
        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='books';";
        Statement statement = databaseDriver.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        assertTrue(resultSet.next());
    }
}
