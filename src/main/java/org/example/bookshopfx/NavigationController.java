package org.example.bookshopfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationController {
    private Stage stage;

    public void showFirstView() {
        try {
            FXMLLoader firstView = new FXMLLoader(HelloApplication.class.getResource("first-view.fxml"));
            stage.getScene().setRoot(firstView.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showSecondView() {
        try {
            FXMLLoader secondView = new FXMLLoader(HelloApplication.class.getResource("second-view.fxml"));
            stage.getScene().setRoot(secondView.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showLoginView() {
        try {
            FXMLLoader secondView = new FXMLLoader(HelloApplication.class.getResource("login/login-view.fxml"));
            stage.getScene().setRoot(secondView.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showHomeView() {
        try {
            FXMLLoader secondView = new FXMLLoader(HelloApplication.class.getResource("home/home.fxml"));
            stage.getScene().setRoot(secondView.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showShopView() {
        try {
            FXMLLoader secondView = new FXMLLoader(HelloApplication.class.getResource("shop/shop.fxml"));
            stage.getScene().setRoot(secondView.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static NavigationController instance = null;

    private NavigationController() {
        try {
            stage = new Stage();
            stage.setTitle("Book Shop");
            FXMLLoader loginView = new FXMLLoader(HelloApplication.class.getResource("login/login-view.fxml"));
            stage.setScene(new Scene(loginView.load()));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        showShopView();

    }

    public static NavigationController getInstance() {
        if(instance == null) {
            instance = new NavigationController();
        }
        return instance;
    }
}
