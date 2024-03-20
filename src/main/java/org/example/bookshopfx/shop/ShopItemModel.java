package org.example.bookshopfx.shop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import org.example.data.models.InventoryItem;

public class ShopItemModel {
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty price = new SimpleStringProperty();
    private final StringProperty stock = new SimpleStringProperty();

    private InventoryItem inventoryItem;

    public StringProperty descriptionProperty() {
        return description;
    }

    public ObservableValue<? extends String> priceProperty() {
        return price;
    }

    public ObservableValue<? extends String> stockProperty() {
        return stock;
    }

    public void setInventoryItem(InventoryItem item) {
        inventoryItem = item;
        description.set(item.getItem().description());
        price.set(item.getItem().getPrice() + "$");
        stock.set(String.valueOf(item.getCount()));
    }

    public InventoryItem getInventoryItem() {
        return inventoryItem;
    }
}
