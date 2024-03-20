package org.example.bookshopfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.Seeder;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)  {
        NavigationController.getInstance();
    }


    public static void main(String[] args) {
        Seeder.seed();
        launch();
    }
}