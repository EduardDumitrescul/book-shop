package org.example.data.repositories;

import org.example.data.entities.ItemEntity;
import org.example.services.ItemService;

import java.util.List;

public interface ItemRepository {

    void update(ItemEntity item);

    List<ItemEntity> getById(List<Integer> ids);

    ItemEntity getById(int id);

    List<ItemEntity> getAll();

    int addItem(ItemEntity entity);

    void delete(int id);
}
