package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AuthorsController implements Initializable {
    public VBox authorsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        authorsList.getChildren().add(Model.getInstance().getViewFactory().populateAuthors());
    }
}
