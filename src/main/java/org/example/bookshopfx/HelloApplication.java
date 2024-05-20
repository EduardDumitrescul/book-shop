package org.example.bookshopfx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.Seeder;
import org.example.services.AuditService;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)  {
        NavigationController.getInstance();
    }


    public static void main(String[] args) {
        AuditService.init();
        launch();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}