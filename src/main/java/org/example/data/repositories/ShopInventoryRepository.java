package org.example.data.repositories;

import org.example.data.entities.ShopInventoryEntity;

import java.util.ArrayList;
import java.util.List;

public class ShopInventoryRepository {
    private List<ShopInventoryEntity> inventories = new ArrayList<>();

    private ShopInventoryRepository() {}

    private static ShopInventoryRepository instance = null;

    public static ShopInventoryRepository getInstance() {
        if(instance == null) {
            instance = new ShopInventoryRepository();
        }
        return instance;
    }
}

