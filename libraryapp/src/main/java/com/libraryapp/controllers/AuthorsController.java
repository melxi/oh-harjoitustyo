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
        ArrayList<String> authors = Model.getInstance().listAuthors();

        for (String author: authors) {
            HBox authorGroup = new HBox();
            authorGroup.getStyleClass().add("author_group");
            Label name = new Label(author);
            Button viewButton = new Button("View");
            viewButton.getStyleClass().add("view_author");
            viewButton.setId("viewAuthor");
            Button deleteButton = new Button("Delete");
            deleteButton.getStyleClass().add("delete_author");
            viewButton.setId("deleteAuthor");

            authorGroup.setMargin(viewButton, new Insets(10, 10, 10, 10));
            authorGroup.setMargin(deleteButton, new Insets(10, 0, 10, 0));

            authorGroup.getChildren().addAll(name, viewButton, deleteButton);
            authorsList.getChildren().add(authorGroup);
        }
    }
}
