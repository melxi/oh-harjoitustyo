package com.libraryapp.models;

import com.libraryapp.common.DatabaseDriver;
import com.libraryapp.views.ViewFactory;

import java.sql.ResultSet;

public class Model {
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private static Model model;
    private User user;
    private boolean userLoggedIn;

    private Model() {
        viewFactory = new ViewFactory();
        databaseDriver = new DatabaseDriver();
        this.user = new User("", "", "");
        this.userLoggedIn = false;
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }

        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public DatabaseDriver getDatabaseDriver() {
        return databaseDriver;
    }

    public User getUser() {
        return user;
    }

    public boolean loginUser(String username, String password) {
        ResultSet resultSet = databaseDriver.getUser(username, password);

        try {
            if (resultSet.isBeforeFirst()) {
                this.user.usernameProperty().set(resultSet.getString("username"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
}
