package org.example.data.entities;

import org.example.data.Cloneable;

public class ItemInventoryCrossRef implements Cloneable {
    int itemId;
    int inventoryId;

    public ItemInventoryCrossRef(
            int inventoryId,
            int itemId
    ) {
        this.inventoryId = inventoryId;
        this.itemId = itemId;
    }

    public ItemInventoryCrossRef(ItemInventoryCrossRef obj) {
        this.itemId = obj.itemId;
        this.inventoryId = obj.inventoryId;
    }

    @Override
    public ItemInventoryCrossRef clone() {
        return new ItemInventoryCrossRef(this);
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public int getItemId() {
        return itemId;
    }
}
