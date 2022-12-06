package com.libraryapp.models;

import com.libraryapp.common.DatabaseDriver;
import com.libraryapp.views.ViewFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Model {
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private static Model model;
    private User user;
    ArrayList<String> authors;

    private Model() {
        viewFactory = new ViewFactory();
        databaseDriver = new DatabaseDriver();
        this.user = new User("", "", "");
        authors = new ArrayList<>();
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

    public boolean registerUser(String name, String username, String password) {
        if (databaseDriver.createUser(name, username, password)) {
            return true;
        }

        return false;
    }

    public boolean addAuthor(String name) {
        if (databaseDriver.createAuthor(name)) {
            return true;
        }

        return false;
    }

    public ArrayList<String> listAuthors() {
        ResultSet resultSet = databaseDriver.getAuthors();

        try {
            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    authors.add(resultSet.getString("name"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return authors;
    }
}
