package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    public VBox booksList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        booksList.getChildren().add(Model.getInstance().getViewFactory().populateBooks());
    }
}
