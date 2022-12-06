package com.libraryapp.common;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseDriver {
    private Connection connection;
    
    public DatabaseDriver() {
        String url = "jdbc:sqlite:database.db";
        
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE,
                LocalDateTime.now() + ": Could not connect to SQLite DB");
        }

        createUsersTable();
        createAuthorsTable();
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

    public boolean createUser(String name, String username, String password) {
        String sql = "INSERT INTO users(name,username,password) VALUES(?,?,?)";

        try {
            ResultSet resultSet = getUser(username, password);
            if (!resultSet.isBeforeFirst()) {
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setString(2, username);
                pstmt.setString(3, password);
                pstmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM users where id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(String username, String password) {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    /*
    / Authors
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
    public boolean createAuthor(String name) {
        String sql = "INSERT INTO authors(name) VALUES(?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ResultSet getAuthors() {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM authors";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
