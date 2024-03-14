package org.example.data.repositories;

import org.example.data.entities.ItemInventoryCrossRef;

import java.util.ArrayList;
import java.util.List;

public class ItemInventoryCrossRefRepository {
    private List<ItemInventoryCrossRef> crossRefs = new ArrayList<>();

    public List<Integer> getItemIdsByInventoryId(int inventoryId) {
        List<Integer> ids = new ArrayList<>();
        for(ItemInventoryCrossRef entity: crossRefs) {
            if(entity.getInventoryId() == inventoryId) {
                ids.add(entity.getItemId());
            }
        }
        return ids;
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
