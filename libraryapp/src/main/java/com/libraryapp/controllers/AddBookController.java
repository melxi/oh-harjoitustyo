package com.libraryapp.controllers;

import com.libraryapp.models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AddBookController implements Initializable {
    public Label titleLabel;
    public TextField titleField;
    public Label authorLabel;
    public ChoiceBox<String> authorField;
    public Label dateLabel;
    public DatePicker dateField;
    public Label pagesLabel;
    public Spinner<Integer> pagesField;
    public Button createButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setDefaultValues();

        createButton.setOnAction(event -> handleCreateButton());
    }

    public void setDefaultValues() {
        authorField.getItems().addAll(Model.getInstance().listAuthors());
        SpinnerValueFactory valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000);
        valueFactory.setValue(1);
        pagesField.setValueFactory(valueFactory);
        pagesField.setEditable(true);
    }

    private void handleCreateButton() {
        System.out.println(titleField.getText());
        System.out.println(authorField.getValue());
        System.out.println(dateField.getValue());
        System.out.println(pagesField.getValue());
        if (Model.getInstance().addBook(titleField.getText(), authorField.getValue(), dateField.getValue(), pagesField.getValue()))
            Model.getInstance().getViewFactory().getActiveView().set("Authors");
        setDefaultValues();
    }
}
