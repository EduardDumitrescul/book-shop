package org.example.data.repositories;

import org.example.data.entities.ItemInventoryCrossRef;

import java.util.ArrayList;
import java.util.List;

public class ItemInventoryCrossRefRepository {
    private List<ItemInventoryCrossRef> crossRefs = new ArrayList<>();

    public ItemInventoryCrossRef getInventoryItem(int inventoryId, int itemId) {
        for(ItemInventoryCrossRef entity: crossRefs) {
            if(entity.equals(new ItemInventoryCrossRef(inventoryId, itemId, 0))) {
                return entity.clone();
            }
        }
        return null;
    }

    public void update(ItemInventoryCrossRef itemInventoryCrossRef) {
        int index = crossRefs.indexOf(itemInventoryCrossRef);
        crossRefs.set(index, new ItemInventoryCrossRef(itemInventoryCrossRef));
    }

    public List<ItemInventoryCrossRef> getItemsByInventoryId(int inventoryId) {
        List<ItemInventoryCrossRef> list = new ArrayList<>();
        for(ItemInventoryCrossRef entity: crossRefs) {
            if(entity.getInventoryId() == inventoryId) {
                list.add(entity.clone());
            }
        }
        return list;
    }

    public void add(ItemInventoryCrossRef itemInventoryCrossRef) {
        crossRefs.add(new ItemInventoryCrossRef(itemInventoryCrossRef));
    }

    private ItemInventoryCrossRefRepository() {}
    private static ItemInventoryCrossRefRepository instance;

    public static ItemInventoryCrossRefRepository getInstance() {
        if(instance == null) {
            instance = new ItemInventoryCrossRefRepository();
        }
        return instance;
    }
}
