package org.example.bookshopfx.shop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.data.models.InventoryItem;
import org.example.data.models.Shop;

public class ShopModel {
    private Shop shop;
    private ObservableList<InventoryItem> itemList = FXCollections.observableArrayList();

    public void setShop(Shop shop) {
        this.shop = shop;
        for(InventoryItem inventoryItem: shop.getInventory().getItems()) {
            itemList.add(inventoryItem);
        }
    }

    public ObservableList<InventoryItem> getItemList() {
        return itemList;
    }
}
