package org.example.bookshopfx.shop;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import org.example.bookshopfx.HelloApplication;
import org.example.data.models.InventoryItem;
import org.example.data.models.Item;

import java.io.IOException;

public class ShopItemCell extends ListCell<InventoryItem> {
    private HBox root;


    private ShopItemController controller;


    public ShopItemCell() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("shop/shop-item.fxml"));
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
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
