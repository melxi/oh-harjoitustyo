package com.libraryapp.views;

import com.libraryapp.common.Util;
import com.libraryapp.controllers.LayoutController;
import com.libraryapp.models.Book;
import com.libraryapp.models.Model;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ViewFactory extends Application {
    public Stage stage = new Stage();
    private final StringProperty activeView;
    private AnchorPane loginView;
    private AnchorPane registerView;
    private AnchorPane homeView;
    private AnchorPane authorsView;
    private AnchorPane addAuthorView;
    private AnchorPane booksView;
    private AnchorPane addBookView;

    public ViewFactory() {
        activeView = new SimpleStringProperty("");
    }

    public StringProperty getActiveView() {
        return activeView;
    }
    public void showLayout() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/layout.fxml"));
        LayoutController layoutController = new LayoutController();
        fxmlLoader.setController(layoutController);
        loadPage(fxmlLoader);
    }

    public void showLoginPage() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/login.fxml"));
        loadPage(fxmlLoader);
    }

    public void loadPage(FXMLLoader fxmlLoader) {
        Scene scene = null;

        try {
            scene = new Scene(fxmlLoader.load(), Util.APP_WIDTH, Util.APP_HEIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        stage.setScene(scene);
        stage.setTitle(Util.APP_TITLE);
        stage.show();
    }

    public AnchorPane getLoginView() {
        try {
            loginView = new FXMLLoader(getClass().getResource("/views/login.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginView;
    }

    public AnchorPane getRegisterView() {
        try {
            registerView = new FXMLLoader(getClass().getResource("/views/register.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return registerView;
    }

    public AnchorPane getHomeView() {
        try {
            homeView = new FXMLLoader(getClass().getResource("/views/home.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return homeView;
    }

    public AnchorPane getAuthorsView() {
        try {
            authorsView = new FXMLLoader(getClass().getResource("/views/authors.fxml")).load();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return authorsView;
    }

    public AnchorPane getAddAuthorView() {
        try {
            addAuthorView = new FXMLLoader(getClass().getResource("/views/addauthor.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addAuthorView;
    }

    public AnchorPane getBooksView() {
        try {
            booksView = new FXMLLoader(getClass().getResource("/views/books.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return booksView;
    }

    public AnchorPane getAddBookView() {
        try {
            addBookView = new FXMLLoader(getClass().getResource("/views/addbook.fxml")).load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return addBookView;
    }

    public VBox populateAuthors() {
        ArrayList<String> authors = Model.getInstance().listAuthors();
        VBox authorsList = new VBox();

        for (String author: authors) {
            HBox authorGroup = new HBox();
            authorGroup.getStyleClass().add("author_group");
            Label name = new Label(author);
            Button viewButton = new Button("View");
            viewButton.getStyleClass().add("view_author");
            viewButton.setId("viewAuthor");
            Button deleteButton = new Button("Delete");
            deleteButton.getStyleClass().add("delete_author");
            viewButton.setId("deleteAuthor");

            authorGroup.setMargin(viewButton, new Insets(10, 10, 10, 10));
            authorGroup.setMargin(deleteButton, new Insets(10, 0, 10, 0));

            authorGroup.getChildren().addAll(name, viewButton, deleteButton);
            authorsList.getChildren().add(authorGroup);
        }

        return authorsList;
    }

    public VBox populateBooks() {
        ArrayList<Book> books = Model.getInstance().listBooks();
        VBox booksList = new VBox();

        for (Book book: books) {
//            HBox bookGroup = new HBox();
//            Label title = new Label(book);
            System.out.println(book);

        }

        return booksList;
    }

    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginPage();
    }

    public static void main(String[] args) {
        launch();
    }
}
