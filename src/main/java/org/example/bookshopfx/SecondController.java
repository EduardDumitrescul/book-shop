package org.example.bookshopfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondController {
    @FXML
    protected void onButtonClick(ActionEvent event) {
        NavigationController.getInstance().showFirstView();
    }
}
