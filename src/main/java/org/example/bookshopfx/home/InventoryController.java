package org.example.bookshopfx.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.bookshopfx.shop.ItemCell;
import org.example.services.UserService;

public class InventoryController {
    @FXML
    private ListView itemListView;
    private InventoryModel inventoryModel = new InventoryModel();
    private UserService userService = UserService.getInstance();


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

