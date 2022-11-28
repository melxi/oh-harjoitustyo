package com.libraryapp;

import com.libraryapp.common.Util;
import com.libraryapp.models.Model;
import com.libraryapp.views.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginPage();
    }

    public static void main(String[] args) {
        launch();
    }
}