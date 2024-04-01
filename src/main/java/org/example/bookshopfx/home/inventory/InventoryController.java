package org.example.bookshopfx.home.inventory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.services.UserService;

public class InventoryController {
    @FXML
    private ListView itemListView;
    private final InventoryModel inventoryModel = new InventoryModel();
    private final UserService userService = UserService.getInstance();


    public void back(ActionEvent actionEvent) {
        NavigationController.getInstance().navigateBack();
    }

    @FXML
    public void initialize() {
        setupModel();
    }


    private void setupModel() {
        inventoryModel.setInventory(userService.getCurrentUserInventory());
        itemListView.refresh();
        itemListView.setItems(inventoryModel.getItemIds());
        itemListView.setCellFactory(listView -> new ItemCell());
    }
}

