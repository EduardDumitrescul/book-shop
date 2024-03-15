package org.example.services;

import org.example.data.entities.ItemEntity;
import org.example.data.entities.ItemInventoryCrossRef;
import org.example.data.mappers.ItemMapper;
import org.example.data.models.InventoryItem;
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

    public List<InventoryItem> getItemsByInventoryId(int inventoryId) {
        try {
            List<ItemInventoryCrossRef> itemInventoryCrossRefs = itemInventoryCrossRefRepository.getItemsByInventoryId(inventoryId);
            List<InventoryItem> items = new ArrayList<>();
            for(ItemInventoryCrossRef entity: itemInventoryCrossRefs) {
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
            ItemInventoryCrossRef itemInventoryCrossRef = itemInventoryCrossRefRepository.getInventoryItem(inventoryId, itemId);
            itemInventoryCrossRef.count += 1;
            itemInventoryCrossRefRepository.update(itemInventoryCrossRef);
        }
        else {
            itemInventoryCrossRefRepository.add(new ItemInventoryCrossRef(inventoryId, itemId, 1));
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
