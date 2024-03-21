package org.example.bookshopfx.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.bookshopfx.HelloApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class NavigationController {
    private Stage stage;

    private Stack<Screen> navStack = new Stack<>();
    private List<Screen> screens = new ArrayList<>(List.of(
            new Screen("login", "login/login.fxml", List.of()),
            new Screen("home", "home/home.fxml", List.of()),
            new Screen("shop", "shop/shop.fxml", List.of()),
            new Screen("inventory", "home/inventory.fxml", List.of()),
            new Screen("view-book", "item/view-book.fxml", List.of()),
            new Screen("view-coloring-book", "item/view-coloring-book.fxml", List.of()),
            new Screen("view-cookbook", "item/view-cookbook.fxml", List.of()),
            new Screen("view-notebook", "item/view-notebook.fxml", List.of())
    ));

    public void showScreen(String tag, List<String> args) {
        try {
            for(Screen screen: screens) {
                if(Objects.equals(screen.tag, tag)) {
                    screen.args = args;
                    navStack.push(screen);
                    stage.getScene().setRoot(screen.loader().load());
                }
            }

        } catch (IOException e) {
             throw new RuntimeException(e);
        }
    }

    public List<String> getArguments() {
        return navStack.peek().args;
    }

    public void navigateBack() {
        try {
            navStack.pop();
            Screen screen = navStack.pop();
            showScreen(screen.tag, screen.args);
        } catch (Exception e) {
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
    }

    public static NavigationController getInstance() {
        if(instance == null) {
            instance = new NavigationController();
        }
        return instance;
    }
}
