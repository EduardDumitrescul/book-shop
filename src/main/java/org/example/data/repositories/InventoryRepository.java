package org.example.data.repositories;

import org.example.data.entities.InventoryEntity;

public interface InventoryRepository {

    int add(InventoryEntity entity);

    InventoryEntity getById(int id);
}
