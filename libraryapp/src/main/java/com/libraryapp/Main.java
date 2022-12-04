package com.libraryapp;

import com.libraryapp.models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginPage();
    }

    public static void main(String[] args) {
        launch();
    }
}