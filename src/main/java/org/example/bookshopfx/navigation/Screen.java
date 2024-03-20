package org.example.bookshopfx.navigation;

import javafx.fxml.FXMLLoader;
import org.example.bookshopfx.HelloApplication;

public class Screen {
    public FXMLLoader loader;
    public String tag;
    public Screen(
            String tag,
            String fxmlRoute
    ) {
        loader = new FXMLLoader(HelloApplication.class.getResource(fxmlRoute));
        this.tag = tag;
    }
}
