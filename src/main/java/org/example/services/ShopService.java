package org.example.services;

import org.example.data.entities.ItemEntity;
import org.example.data.mappers.ItemMapper;
import org.example.data.models.Item;
import org.example.data.repositories.ItemInventoryCrossRefRepository;
import org.example.data.repositories.ItemRepository;
import org.example.data.repositories.ShopInventoryRepository;
import org.example.data.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private ShopRepository shopRepository = ShopRepository.getInstance();
    private ShopInventoryRepository shopInventoryRepository = ShopInventoryRepository.getInstance();
    private ItemInventoryCrossRefRepository itemInventoryCrossRefRepository = ItemInventoryCrossRefRepository.getInstance();
    private ItemRepository itemRepository = ItemRepository.getInstance();

    public List<Item> getItemsByInventoryId(int inventoryId) {
        try {
            List<Integer> itemIds = itemInventoryCrossRefRepository.getItemIdsByInventoryId(inventoryId);
            List<ItemEntity> itemEntities = itemRepository.getById(itemIds);
            List<Item> items = itemEntities.stream().map(ItemMapper::asItem).toList();
            return items;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }



    private ShopService() {}

    private static ShopService instance = null;

    public static ShopService getInstance() {
        if(instance == null) {
            instance = new ShopService();
        }
        return instance;
    }
}
