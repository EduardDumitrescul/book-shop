package org.example.bookshopfx.home.inventory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.data.models.Item;

public class ItemCellModel {
    private Item item;

    private final StringProperty description = new SimpleStringProperty();

    public void setItem(Item item) {
        this.item = item;
        description.set(item.description());
    }

    public Item getItem() {
        return item;
    }

    public StringProperty descriptionProperty() {
        return description;
    }
}
