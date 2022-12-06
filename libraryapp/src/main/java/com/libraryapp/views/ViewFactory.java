package com.libraryapp.views;

import com.libraryapp.common.Util;
import com.libraryapp.controllers.LayoutController;
import com.libraryapp.models.Model;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        if (loginView == null) {
            try {
                loginView = new FXMLLoader(getClass().getResource("/views/login.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return loginView;
    }

    public AnchorPane getRegisterView() {
        if (registerView == null) {
            try {
                registerView = new FXMLLoader(getClass().getResource("/views/register.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return registerView;
    }

    public AnchorPane getHomeView() {
        if (homeView == null) {
            try {
                homeView = new FXMLLoader(getClass().getResource("/views/home.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return homeView;
    }

    public AnchorPane getAuthorsView() {
        if (authorsView == null) {
            try {
                authorsView = new FXMLLoader(getClass().getResource("/views/authors.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return authorsView;
    }

    public AnchorPane getAddAuthorView() {
        if (addAuthorView == null) {
            try {
                addAuthorView = new FXMLLoader(getClass().getResource("/views/addauthor.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return addAuthorView;
    }

    public AnchorPane getBooksView() {
        if (booksView == null) {
            try {
                booksView = new FXMLLoader(getClass().getResource("/views/books.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return booksView;
    }

    public AnchorPane getAddBookView() {
        if (addBookView == null) {
            try {
                addBookView = new FXMLLoader(getClass().getResource("/views/addbook.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return addBookView;
    }

    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginPage();
    }

    public static void main(String[] args) {
        launch();
    }
}
