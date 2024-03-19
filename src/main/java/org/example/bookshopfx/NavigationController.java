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

    private static NavigationController instance = null;

    private NavigationController() {
        try {
            stage = new Stage();
            stage.setTitle("Book Shop");
            FXMLLoader firstView = new FXMLLoader(HelloApplication.class.getResource("first-view.fxml"));
            Scene scene = new Scene(firstView.load(), 320, 240);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static NavigationController getInstance() {
        if(instance == null) {
            instance = new NavigationController();
        }
        return instance;
    }
}
