package org.example.data.mappers;

import org.example.data.entities.ItemEntity;
import org.example.data.models.Item;

public class ItemMapper {
    private ItemMapper() {}

    public static Item asItem(ItemEntity entity) {
        return new Item(entity.getId(), entity.getPrice());
    }
}
