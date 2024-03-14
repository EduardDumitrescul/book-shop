package org.example.data.entities;

public class ItemInventoryCrossRef {
    int itemId;
    int inventoryId;

    public ItemInventoryCrossRef(
            int inventoryId,
            int itemId
    ) {
        this.inventoryId = inventoryId;
        this.itemId = itemId;
    }
}
