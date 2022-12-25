package com.libraryapp.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookDAO {
    public boolean createBook(String title, String author, LocalDate date, Integer pages) {
        String sql = "INSERT INTO books(title, author, publish_date, pages) VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = DatabaseDriver.connection.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setDate(3, Date.valueOf(date));
            pstmt.setInt(4, pages);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public ResultSet getBooks() {
        ResultSet resultSet = null;
        String sql = "SELECT * FROM books";

        try {
            PreparedStatement pstmt = DatabaseDriver.connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
