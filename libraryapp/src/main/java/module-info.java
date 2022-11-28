module com.libraryapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    requires org.kordamp.bootstrapfx.core;

    opens com.libraryapp to javafx.fxml;
    exports com.libraryapp;
    exports com.libraryapp.controllers;
    exports com.libraryapp.models;
    exports com.libraryapp.views;
}