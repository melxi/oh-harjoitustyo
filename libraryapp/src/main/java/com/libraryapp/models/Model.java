package com.libraryapp.models;

import com.libraryapp.dao.AuthorDAO;
import com.libraryapp.dao.BookDAO;
import com.libraryapp.dao.DatabaseDriver;
import com.libraryapp.dao.UserDAO;
import com.libraryapp.views.ViewFactory;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

public class Model {
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;
    private static Model model;
    private User user;
    private UserDAO userDAO;
    private AuthorDAO authorDAO;
    private ArrayList<String> authors;
    private BookDAO bookDAO;

    private Model() {
        viewFactory = new ViewFactory();
        databaseDriver = new DatabaseDriver();
        userDAO = new UserDAO();
        authorDAO = new AuthorDAO();
        this.user = new User("", "", "");
        authors = new ArrayList<>();
        bookDAO = new BookDAO();
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

    public User getUser() {
        return user;
    }

    public boolean loginUser(String username, String password) {
        ResultSet resultSet = userDAO.getUser(username, password);

        try {
            if (resultSet.isBeforeFirst()) {
                this.user.nameProperty().set(resultSet.getString("name"));
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
        if (userDAO.createUser(name, username, password)) {
            return true;
        }

        return false;
    }

    public boolean addAuthor(String name) {
        if (authorDAO.createAuthor(name)) {
            return true;
        }

        return false;
    }

    public ArrayList<String> listAuthors() {
        authors = new ArrayList<>();
        ResultSet resultSet = authorDAO.getAuthors();

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

    public boolean addBook(String title, String author, LocalDate date, Integer pages) {
        System.out.println("addBook " + title);
        if (bookDAO.createBook(title, author, date, pages)) {
            return true;
        }

        return false;
    }
}
