package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable {
    public BorderPane layoutParent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getActiveView().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Authors":
                    layoutParent.setCenter(Model.getInstance().getViewFactory().getAuthorsView());
                    return;
                case "Add author":
                    layoutParent.setCenter(Model.getInstance().getViewFactory().getAddAuthorView());
                    return;
                case "Books":
                    layoutParent.setCenter(Model.getInstance().getViewFactory().getBooksView());
                    return;
                case "Add book":
                    layoutParent.setCenter(Model.getInstance().getViewFactory().getAddBookView());
                    return;
                case "Login":
                    layoutParent.setTop(null);
                    layoutParent.setCenter(Model.getInstance().getViewFactory().getLoginView());
                    return;
                case "Register":
                    layoutParent.setTop(null);
                    layoutParent.setCenter(Model.getInstance().getViewFactory().getRegisterView());
                    return;
                default:
                    layoutParent.setCenter(Model.getInstance().getViewFactory().getHomeView());
            }
        });
    }
}
