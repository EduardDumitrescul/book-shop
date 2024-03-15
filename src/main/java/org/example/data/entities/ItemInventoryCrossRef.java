package org.example.data.entities;

import org.example.data.Cloneable;

import java.util.Objects;

public class ItemInventoryCrossRef implements Cloneable {
    public int itemId;
    public int inventoryId;

    public int count;

    public ItemInventoryCrossRef(
            int inventoryId,
            int itemId,
            int count
    ) {
        this.inventoryId = inventoryId;
        this.itemId = itemId;
        this.count = count;
    }

    public ItemInventoryCrossRef(ItemInventoryCrossRef obj) {
        this.itemId = obj.itemId;
        this.inventoryId = obj.inventoryId;
        this.count = obj.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemInventoryCrossRef that = (ItemInventoryCrossRef) o;
        return itemId == that.itemId && inventoryId == that.inventoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, inventoryId);
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
