package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import com.libraryapp.views.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    ViewFactory viewFactory = new ViewFactory();
    public Label usernameLabel;
    public TextField usernameField;
    public Label passwordLabel;
    public PasswordField passwordField;
    public Button loginButton;
    public Button registerButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(event -> onLogin());
        registerButton.setOnAction(event -> handleRegisterButton());
    }

    private void handleRegisterButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Register");
    }

    public void onLogin() {
        if (Model.getInstance().loginUser(usernameField.getText(), passwordField.getText())) {
            Model.getInstance().getViewFactory().showLayout();
            usernameField.setText("");
            passwordField.setText("");
        } else {
            usernameField.setText("");
            passwordField.setText("");
        }
    }
}