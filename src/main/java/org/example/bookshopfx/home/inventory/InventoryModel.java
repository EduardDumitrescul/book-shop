package org.example.bookshopfx.home.inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.data.models.Item;
import org.example.data.models.UserInventory;

public class InventoryModel {
    private UserInventory inventory;

    private ObservableList<Integer> itemIds = FXCollections.observableArrayList();

    public void setInventory(UserInventory inventory) {
        this.inventory = inventory;
        itemIds.clear();
        for(Item item: inventory.getItems()) {
            itemIds.add(item.getId());
        }
    }

    public ObservableList<Integer> getItemIds() {
        return itemIds;
    }
}
