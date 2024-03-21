package org.example.bookshopfx.navigation;

import javafx.fxml.FXMLLoader;
import org.example.bookshopfx.HelloApplication;

import java.util.List;

public class Screen {
    public String fxmlRoute;
    public String tag;

    public List<String> args;
    public Screen(
            String tag,
            String fxmlRoute,
            List<String> args
    ) {
        this.fxmlRoute = fxmlRoute;
        this.tag = tag;
        this.args = args;
    }

    public FXMLLoader loader() {
        return new FXMLLoader(HelloApplication.class.getResource(fxmlRoute));
    }
}
