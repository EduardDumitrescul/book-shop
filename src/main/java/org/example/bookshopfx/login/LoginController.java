package org.example.bookshopfx.login;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.bookshopfx.NavigationController;
import org.example.services.UserService;

public class LoginController {

    public Text helperText;
    private UserService userService = UserService.getInstance();

    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    @FXML
    void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            userService.login(username, password);
            NavigationController navController = NavigationController.getInstance();
            navController.showHomeView();
        } catch (Exception e) {
            helperText.setText(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @FXML
    void register() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        try {
            userService.register(username, password);
            NavigationController navController = NavigationController.getInstance();
            navController.showHomeView();
        } catch (Exception e) {
            helperText.setText(e.getMessage());
        }
    }
}
