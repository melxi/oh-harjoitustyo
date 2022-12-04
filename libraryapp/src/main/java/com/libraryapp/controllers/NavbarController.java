package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class NavbarController implements Initializable {
    public Button homeButton;
    public Button authorsButton;
    public Button addAuthorButton;
    public Button booksButton;
    public Button addBookButton;
    public Button logoutButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    public void addListeners() {
        homeButton.setOnAction(event -> handleHomeButton());
        authorsButton.setOnAction(event -> handleAuthorsButton());
        addAuthorButton.setOnAction(event -> handleAddAuthorButton());
        booksButton.setOnAction(event -> handleBooksButton());
        addBookButton.setOnAction(event -> handleAddBookButton());
        logoutButton.setOnAction(event -> handleLogoutButton());
    }

    private void handleHomeButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Home");
    }

    private void handleAuthorsButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Authors");
    }

    private void handleAddAuthorButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Add author");
    }

    private void handleBooksButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Books");
    }

    private void handleAddBookButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Add book");
    }
    private void handleLogoutButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Login");
    }
}
