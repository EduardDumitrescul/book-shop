package org.example.services;

import org.example.data.entities.ItemEntity;
import org.example.data.mappers.ItemMapper;
import org.example.data.models.Item;
import org.example.data.repositories.ItemRepository;

public class ItemService {
    private ItemRepository itemRepository = ItemRepository.getInstance();

    public Item getItem(int id) {
        ItemEntity itemEntity = itemRepository.getById(id);
        Item item = ItemMapper.asItem(itemEntity);
        return item;
    }

    private static ItemService instance = null;
    private ItemService() {}

    public static ItemService getInstance() {
        if(instance == null) {
            instance = new ItemService();
        }
        return instance;
    }
}
