package com.libraryapp.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private StringProperty name;
    private StringProperty username;
    private StringProperty password;

    public User(String name, String username, String password) {
        this.name = new SimpleStringProperty(this, name);
        this.username = new SimpleStringProperty(this, username);
        this.password = new SimpleStringProperty(this, password);
    }

    public StringProperty nameProperty() {
        return this.name;
    }
    public StringProperty usernameProperty() {
        return this.username;
    }
}
