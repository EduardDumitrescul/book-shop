package org.example.data.repositories;

import org.example.data.entities.ItemInventoryCrossRef;

import java.util.ArrayList;
import java.util.List;

public class ItemInventoryCrossRefRepository {
    private List<ItemInventoryCrossRef> crossRefs = new ArrayList<>();

    private ItemInventoryCrossRefRepository() {}
    private static ItemInventoryCrossRefRepository instance;

    public static ItemInventoryCrossRefRepository getInstance() {
        if(instance == null) {
            instance = new ItemInventoryCrossRefRepository();
        }
        return instance;
    }
}
