package com.libraryapp.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class Book {
    private StringProperty title;
    private StringProperty author;
    private StringProperty publishDate;
    private IntegerProperty pages;


    public Book(String title, String author, Date publishDate, Integer pages) {
        this.title = new SimpleStringProperty(this, title);
        this.author = new SimpleStringProperty(this, author);
        this.publishDate = new SimpleStringProperty(this, publishDate.toString());
        this.pages = new SimpleIntegerProperty(this, pages.toString());
    }

    public StringProperty titleProperty() {
        return this.title;
    }

    public String toString() {
        return this.title.get();
    }
}
