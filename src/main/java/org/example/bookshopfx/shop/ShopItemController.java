package org.example.bookshopfx.shop;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import org.example.data.models.InventoryItem;

public class ShopItemController {
    @FXML
    public Label text;
    public Label price;
    public Label stock;
    private InventoryItem inventoryItem;

    public void setInventoryItem(InventoryItem inventoryItem) {
        this.inventoryItem = inventoryItem;
        text.textProperty().set(inventoryItem.getItem().description());
        price.textProperty().set(inventoryItem.getItem().getPrice() + "$");
        stock.textProperty().set(String.valueOf(inventoryItem.getCount()));
    }
}
