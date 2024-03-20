package org.example.bookshopfx.navigation;

import javafx.fxml.FXMLLoader;
import org.example.bookshopfx.HelloApplication;

public class Screen {
    private String fxmlRoute;
    public String tag;
    public Screen(
            String tag,
            String fxmlRoute
    ) {
        this.fxmlRoute = fxmlRoute;
        this.tag = tag;
    }

    public FXMLLoader loader() {
        return new FXMLLoader(HelloApplication.class.getResource(fxmlRoute));
    }
}
