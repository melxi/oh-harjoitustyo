package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddAuthorController implements Initializable {
    public Label nameLabel;
    public TextField nameField;
    public Button createButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createButton.setOnAction(event -> handleCreateButton());
    }

    private void handleCreateButton() {
        if (Model.getInstance().addAuthor(nameField.getText()))
            Model.getInstance().getViewFactory().getActiveView().set("Authors");
    }
}
