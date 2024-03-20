package org.example.bookshopfx.shop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.data.models.InventoryItem;
import org.example.data.models.Shop;

public class ShopModel {
    private Shop shop;
    private ObservableList<String> itemList = FXCollections.observableArrayList();

    public void setShop(Shop shop) {
        this.shop = shop;
        for(InventoryItem inventoryItem: shop.getInventory().getItems()) {
            itemList.add(String.valueOf(inventoryItem.getItem().description()));
        }
    }

    public ObservableList<String> getItemList() {
        return itemList;
    }
}
