package com.libraryapp.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Author {
    private StringProperty name;

    public Author(String name) {
        this.name = new SimpleStringProperty(this, name);
    }

    public StringProperty nameProperty() {
        return this.name;
    }
}
