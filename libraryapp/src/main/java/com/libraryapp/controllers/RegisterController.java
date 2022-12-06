package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public Label nameLabel;
    public TextField nameField;
    public Label usernameLabel;
    public TextField usernameField;
    public Label passwordLabel;
    public PasswordField passwordField;
    public Button registerButton;
    public Button loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerButton.setOnAction(event -> onRegister());
        loginButton.setOnAction(event -> handleLoginButton());
    }

    private void handleLoginButton() {
        Model.getInstance().getViewFactory().getActiveView().set("Login");
    }

    public void onRegister() {

        if (Model.getInstance().registerUser(nameField.getText(), usernameField.getText(), passwordField.getText())) {
            Model.getInstance().getViewFactory().showLayout();
        }

        nameField.setText("");
        usernameField.setText("");
        passwordField.setText("");
    }
}
