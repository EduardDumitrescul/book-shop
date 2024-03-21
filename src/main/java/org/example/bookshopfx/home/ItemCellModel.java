package org.example.bookshopfx.home;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.data.models.Item;

public class ItemCellModel {
    private Item item;

    private StringProperty description = new SimpleStringProperty();

    public void setItem(Item item) {
        this.item = item;
        description.set(item.description());
    }

    public StringProperty descriptionProperty() {
        return description;
    }
}
