package org.example.bookshopfx.shop;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import org.example.bookshopfx.HelloApplication;
import org.example.data.models.InventoryItem;

import java.io.IOException;

public class ShopItemCell extends ListCell<InventoryItem> {
    private final HBox root;


    private final ShopItemController controller;


    public ShopItemCell(UpdateShopCallback updateShopCallback) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("shop/shop-item.fxml"));
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
            controller.setUpdateShopCallback(updateShopCallback);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void updateItem(InventoryItem item, boolean empty) {
        super.updateItem(item, empty);
        if(empty) {
            setGraphic(null);
        }
        else {
            controller.setInventoryItem(item);
            setGraphic(root);
        }
    }
}
