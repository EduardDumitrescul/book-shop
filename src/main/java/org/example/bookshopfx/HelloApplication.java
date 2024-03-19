package org.example.bookshopfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.data.Seeder;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        NavigationController.getInstance();
    }


    public static void main(String[] args) {
        Seeder.seed();
        launch();
    }
}