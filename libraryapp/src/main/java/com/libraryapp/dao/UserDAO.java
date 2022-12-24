package com.libraryapp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public boolean createUser(String name, String username, String password) {
        String sql = "INSERT INTO users(name,username,password) VALUES(?,?,?)";

        try {
            ResultSet resultSet = getUser(username, password);
            if (!resultSet.isBeforeFirst()) {
                PreparedStatement pstmt = DatabaseDriver.connection.prepareStatement(sql);
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
            PreparedStatement pstmt = DatabaseDriver.connection.prepareStatement(sql);
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
            PreparedStatement pstmt = DatabaseDriver.connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            resultSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
