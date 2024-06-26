package org.example.data.local;

import org.example.data.entities.InventoryItemCrossRef;
import org.example.data.repositories.ItemInventoryCrossRefRepository;

import java.util.ArrayList;
import java.util.List;

public class LocalItemInventoryCrossRefRepository implements ItemInventoryCrossRefRepository {
    private final List<InventoryItemCrossRef> crossRefs = new ArrayList<>();

    public InventoryItemCrossRef getInventoryItem(int inventoryId, int itemId) {
        for(InventoryItemCrossRef entity: crossRefs) {
            if(entity.equals(new InventoryItemCrossRef(inventoryId, itemId, 0))) {
                return entity.clone();
            }
        }
        return null;
    }

    public void update(InventoryItemCrossRef inventoryItemCrossRef) {
        int index = crossRefs.indexOf(inventoryItemCrossRef);
        crossRefs.set(index, new InventoryItemCrossRef(inventoryItemCrossRef));
    }

    public List<InventoryItemCrossRef> getItemsByInventoryId(int inventoryId) {
        List<InventoryItemCrossRef> list = new ArrayList<>();
        for(InventoryItemCrossRef entity: crossRefs) {
            if(entity.getInventoryId() == inventoryId) {
                list.add(entity.clone());
            }
        }
        return list;
    }

    public void add(InventoryItemCrossRef inventoryItemCrossRef) {
        crossRefs.add(new InventoryItemCrossRef(inventoryItemCrossRef));
    }

    public void deleteByItemId(int itemId) {
        for(int i = 0; i < crossRefs.size(); i ++) {
            if(crossRefs.get(i).itemId == itemId) {
                crossRefs.remove(i);
                i --;
            }
        }
    }
    private LocalItemInventoryCrossRefRepository() {}
    private static LocalItemInventoryCrossRefRepository instance;

    public static LocalItemInventoryCrossRefRepository getInstance() {
        if(instance == null) {
            instance = new LocalItemInventoryCrossRefRepository();
        }
        return instance;
    }
}
