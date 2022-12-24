package com.libraryapp.dao;

import com.libraryapp.common.Util;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseDriver {
    protected static Connection connection;
    
    public DatabaseDriver() {
        try {
            connection = DriverManager.getConnection(Util.DB_URL);
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                LocalDateTime.now() + ": Could not connect to SQLite DB");
        }

        createUsersTable();
        createAuthorsTable();
        createBooksTable();
    }

    /*
    / User
    */
    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id INTEGER PRIMARY KEY,\n"
                + "	name TEXT NOT NULL,\n"
                + "	username TEXT NOT NULL UNIQUE,\n"
                + "	password TEXT NOT NULL\n"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*
    / Author
    */
    public void createAuthorsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS authors (\n"
                + "	id INTEGER PRIMARY KEY,\n"
                + "	name TEXT NOT NULL\n"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createBooksTable() {
        String sql = "CREATE TABLE IF NOT EXISTS books (\n"
                + "	id INTEGER PRIMARY KEY,\n"
                + "	title TEXT NOT NULL,\n"
                + "	author TEXT NOT NULL,\n"
                + "	publish_date DATE NOT NULL,\n"
                + "	pages INT NOT NULL\n"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
