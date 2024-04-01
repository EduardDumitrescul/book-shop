package org.example.bookshopfx.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.services.AuditService;
import org.example.services.UserService;

import java.util.List;

public class HomeController {

    @FXML
    public Text numberOfColoringBooks;
    @FXML
    public Text numberOfNotebooks;
    @FXML
    public Text numberOfCookbooks;
    @FXML
    public Text numberOfBooks;
    @FXML
    public Text usernameText;

    private final UserService userService = UserService.getInstance();

    private final HomeModel homeModel;



    public HomeController() {
        homeModel = new HomeModel();
        homeModel.setUser(userService.getCurrentUser());

    }

    @FXML
    public void initialize() {
        usernameText.textProperty().bind(homeModel.usernameProperty());
        numberOfBooks.textProperty().bind(homeModel.numberOfBooksProperty());
        numberOfCookbooks.textProperty().bind(homeModel.numberOfCookbooksProperty());
        numberOfColoringBooks.textProperty().bind(homeModel.numberOfColoringBooksProperty());
        numberOfNotebooks.textProperty().bind(homeModel.numberOfNotebooksProperty());

    }

    public void showInventory(ActionEvent actionEvent) {
        NavigationController.getInstance().showScreen("inventory", List.of());
        AuditService.log(AuditService.Action.VIEW_USER_INVENTORY);
    }

    public void showShop(ActionEvent actionEvent) {
        NavigationController.getInstance().showScreen("shop", List.of());
        AuditService.log(AuditService.Action.VIEW_SHOP_INVENTORY);
    }

    public void logout(ActionEvent actionEvent) {
        NavigationController.getInstance().navigateBack();
        AuditService.log(AuditService.Action.LOGOUT);
    }
}
