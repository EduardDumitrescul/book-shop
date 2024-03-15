package org.example.data.repositories;

import org.example.data.entities.InventoryEntity;

import java.util.ArrayList;
import java.util.List;

public class ShopInventoryRepository {
    private List<InventoryEntity> inventories = new ArrayList<>();

    public InventoryEntity getById(int id) {
        for(InventoryEntity entity: inventories) {
            if(entity.getId() == id) {
                return new InventoryEntity(entity);
            }
        }
        return null;
    }


    private ShopInventoryRepository() {}

    private static ShopInventoryRepository instance = null;

    public static ShopInventoryRepository getInstance() {
        if(instance == null) {
            instance = new ShopInventoryRepository();
        }
        return instance;
    }
}

