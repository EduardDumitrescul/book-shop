package org.example.services;

import org.example.data.RepositoryProvider;
import org.example.data.entities.*;
import org.example.data.local.*;
import org.example.data.mappers.ItemMapper;
import org.example.data.mappers.ShopMapper;
import org.example.data.models.InventoryItem;
import org.example.data.models.Item;
import org.example.data.models.Shop;
import org.example.data.models.ShopInventory;
import org.example.data.repositories.InventoryRepository;
import org.example.data.repositories.ItemInventoryCrossRefRepository;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    private ItemService itemService = ItemService.getInstance();
    private LocalShopRepository shopRepository = LocalShopRepository.getInstance();
    private InventoryRepository inventoryRepository = RepositoryProvider.provideInventoryRepository();
    private ItemInventoryCrossRefRepository itemInventoryCrossRefRepository = RepositoryProvider.provideItemInventoryCrossRefRepository();
    private LocalItemRepository itemRepository = LocalItemRepository.getInstance();

    private LocalUserRepository userRepository = LocalUserRepository.getInstance();

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
        try {
            removeItemFromShopInventory(shopId, itemId);
            addItemToUserInventory(userId, itemId);
        } catch (Exception ignored) {

        }

    }
    public void buyItem(int userId, int itemId) {
        try {
            removeItemFromShopInventory(1, itemId);
            addItemToUserInventory(userId, itemId);
        }
        catch (Exception ignored) {

        }

    }

    public InventoryItem getInventoryItem(int itemId) {
        try {
            int shopId = 1;
            int inventoryId = getShopInventory(shopId).getId();
            InventoryItemCrossRef inventoryItemCrossRef = itemInventoryCrossRefRepository.getInventoryItem(inventoryId, itemId);
            ItemEntity itemEntity = itemRepository.getById(inventoryItemCrossRef.itemId);
            InventoryItem item = ItemMapper.asInventoryItem(itemEntity, inventoryItemCrossRef.count);
            return item;
        } catch (Exception e) {
            ItemEntity itemEntity = itemRepository.getById(itemId);
            InventoryItem item = ItemMapper.asInventoryItem(itemEntity, 0);
            return item;
        }

    }

    public void removeItemFromShopInventory(int shopId, int itemId) throws Exception {


        ShopEntity shopEntity = shopRepository.getById(shopId);
        int inventoryId = shopEntity.inventoryId;
        InventoryItemCrossRef inventoryItemCrossRef = itemInventoryCrossRefRepository.getInventoryItem(inventoryId, itemId);
        if(inventoryItemCrossRef.count <= 0) {
            throw new Exception("item not in stock");
        }
        inventoryItemCrossRef.count -= 1;
        itemInventoryCrossRefRepository.update(inventoryItemCrossRef);





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
        Item item = itemService.getItem(itemId);
        int newItemId = itemService.addItem(item);
        UserEntity userEntity = userRepository.getUser(userId);
        itemInventoryCrossRefRepository.add(new InventoryItemCrossRef(userEntity.inventoryId, newItemId, 1));
    }

    public void addItemToShopInventory(int itemId, int shopId) {
        addItemToShop(itemId, shopId);

    }
    public void addItemToShopInventory(int itemId) {
        int shopId = 1;
        addItemToShop(itemId, shopId);

    }

    private void addItemToShop(int itemId, int shopId) {
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

    public boolean isOwner(int userId) {
        Shop shop = getShop();
        if(shop.getOwnerId() == userId) {
            return true;
        }
        return false;
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
