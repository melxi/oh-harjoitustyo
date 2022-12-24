package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public Text greetingLabel;
    public Text nameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameLabel.setText(Model.getInstance().getUser().nameProperty().getValue());
    }
}
