package org.example.data.repositories;

import org.example.data.entities.InventoryItemCrossRef;

import java.util.List;

public interface ItemInventoryCrossRefRepository {
    InventoryItemCrossRef getInventoryItem(int inventoryId, int itemId);

    void update(InventoryItemCrossRef inventoryItemCrossRef);

    List<InventoryItemCrossRef> getItemsByInventoryId(int inventoryId);

    void add(InventoryItemCrossRef inventoryItemCrossRef);

    void deleteByItemId(int itemId);
}
