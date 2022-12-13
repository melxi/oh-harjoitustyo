package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AuthorsController implements Initializable {

    public ListView<String> authorsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("loaded");
        ArrayList<String> authors = Model.getInstance().listAuthors();
        for (String author: authors) {
            System.out.println(author);
        }
        authorsList.getItems().addAll(authors);
    }
}
