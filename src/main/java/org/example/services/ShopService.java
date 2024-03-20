package org.example.services;

import org.example.data.entities.*;
import org.example.data.mappers.ItemMapper;
import org.example.data.mappers.ShopMapper;
import org.example.data.models.InventoryItem;
import org.example.data.models.Item;
import org.example.data.models.Shop;
import org.example.data.models.ShopInventory;
import org.example.data.repositories.*;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private ItemService itemService = ItemService.getInstance();
    private ShopRepository shopRepository = ShopRepository.getInstance();
    private InventoryRepository inventoryRepository = InventoryRepository.getInstance();
    private ItemInventoryCrossRefRepository itemInventoryCrossRefRepository = ItemInventoryCrossRefRepository.getInstance();
    private ItemRepository itemRepository = ItemRepository.getInstance();

    private UserRepository userRepository = UserRepository.getInstance();

    public List<InventoryItem> getItemsByInventoryId(int inventoryId) {
        try {
            List<InventoryItemCrossRef> inventoryItemCrossRefs = itemInventoryCrossRefRepository.getItemsByInventoryId(inventoryId);
            List<InventoryItem> items = new ArrayList<>();
            for(InventoryItemCrossRef entity: inventoryItemCrossRefs) {
                Item item = itemService.getItem(entity.itemId);
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

    public void buyItem(int shopId, int userId, int itemId) {
        removeItemFromShopInventory(shopId, itemId);
        addItemToUserInventory(userId, itemId);
    }

    public void removeItemFromShopInventory(int shopId, int itemId) {
        ShopEntity shopEntity = shopRepository.getById(shopId);
        int inventoryId = shopEntity.inventoryId;
        InventoryItemCrossRef inventoryItemCrossRef = itemInventoryCrossRefRepository.getInventoryItem(inventoryId, itemId);
        if(inventoryItemCrossRef.count  == 1) {
            itemInventoryCrossRefRepository.delete(inventoryItemCrossRef);
        }
        else {
            inventoryItemCrossRef.count -= 1;
            itemInventoryCrossRefRepository.update(inventoryItemCrossRef);
        }

    }

    public ShopInventory getShopInventory(int shopId) {
        ShopEntity shopEntity = shopRepository.getById(shopId);
        InventoryEntity inventoryEntity = inventoryRepository.getById(shopEntity.inventoryId);
        ShopInventory shopInventory = new ShopInventory(
                inventoryEntity.id,
                getItemsByInventoryId(inventoryEntity.id));
        return new ShopInventory(shopInventory);
    }

    public Shop getShop() {
        int id = 1;
        ShopEntity shopEntity = shopRepository.getById(id);
        ShopInventory shopInventory = getShopInventory(id);
        Shop shop = ShopMapper.asShop(shopEntity, shopInventory);
        return shop;
    }

    private void addItemToUserInventory(int userId, int itemId) {
        ItemEntity itemEntity = itemRepository.getById(itemId);
        int newItemId = itemRepository.addItem(itemEntity);
        UserEntity userEntity = userRepository.getUser(userId);
        itemInventoryCrossRefRepository.add(new InventoryItemCrossRef(userEntity.inventoryId, newItemId, 1));
    }

    public void addItemToShopInventory(int itemId, int shopId) {
        ShopEntity shopEntity = shopRepository.getById(shopId);
        int inventoryId = shopEntity.inventoryId;
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
