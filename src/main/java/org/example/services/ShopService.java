package org.example.services;

import org.example.data.entities.InventoryItemCrossRef;
import org.example.data.entities.ItemEntity;
import org.example.data.mappers.ItemMapper;
import org.example.data.models.InventoryItem;
import org.example.data.models.Item;
import org.example.data.repositories.InventoryRepository;
import org.example.data.repositories.ItemInventoryCrossRefRepository;
import org.example.data.repositories.ItemRepository;
import org.example.data.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

public class ShopService {
    private ShopRepository shopRepository = ShopRepository.getInstance();
    private InventoryRepository inventoryRepository = InventoryRepository.getInstance();
    private ItemInventoryCrossRefRepository itemInventoryCrossRefRepository = ItemInventoryCrossRefRepository.getInstance();
    private ItemRepository itemRepository = ItemRepository.getInstance();

    public List<InventoryItem> getItemsByInventoryId(int inventoryId) {
        try {
            List<InventoryItemCrossRef> inventoryItemCrossRefs = itemInventoryCrossRefRepository.getItemsByInventoryId(inventoryId);
            List<InventoryItem> items = new ArrayList<>();
            for(InventoryItemCrossRef entity: inventoryItemCrossRefs) {
                ItemEntity itemEntity = itemRepository.getById(entity.itemId);
                Item item = ItemMapper.asItem(itemEntity);
                items.add(new InventoryItem(item, entity.count));
            }
            return items;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ArrayList<>();
    }

    private boolean itemExistsInInventory(int inventoryId, int itemId) {
        return itemInventoryCrossRefRepository.getInventoryItem(inventoryId, itemId) != null;
    }

    public void addItemToShopInventory(int itemId, int shopId) {
        int inventoryId = shopRepository.getShopInventoryId(shopId);
        if(itemExistsInInventory(inventoryId, itemId)) {
            InventoryItemCrossRef inventoryItemCrossRef = itemInventoryCrossRefRepository.getInventoryItem(inventoryId, itemId);
            inventoryItemCrossRef.count += 1;
            itemInventoryCrossRefRepository.update(inventoryItemCrossRef);
        }
        else {
            itemInventoryCrossRefRepository.add(new InventoryItemCrossRef(inventoryId, itemId, 1));
        }

    }

    public List<Item> getAllItems() {
        List<ItemEntity> entities =  itemRepository.getAll();
        List<Item> items = entities.stream().map(ItemMapper::asItem).toList();
        return items;
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
