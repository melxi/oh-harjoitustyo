package com.libraryapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    public boolean createAuthor(String name) {
        String sql = "INSERT INTO authors(name) VALUES(?)";

        try {
            PreparedStatement pstmt = DatabaseDriver.connection.prepareStatement(sql);
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
            PreparedStatement pstmt = DatabaseDriver.connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
