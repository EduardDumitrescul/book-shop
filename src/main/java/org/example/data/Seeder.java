package org.example.data;

import org.example.data.entities.*;
import org.example.data.repositories.*;

import java.util.ArrayList;
import java.util.List;

public class Seeder {
    private static ItemRepository itemRepository = ItemRepository.getInstance();
    private static ShopRepository shopRepository = ShopRepository.getInstance();
    private static InventoryRepository inventoryRepository = InventoryRepository.getInstance();
    private static ItemInventoryCrossRefRepository itemInventoryCrossRefRepository = ItemInventoryCrossRefRepository.getInstance();
    private static UserRepository userRepository = UserRepository.getInstance();

    private static List<UserEntity> users = new ArrayList<>(List.of(
            new UserEntity(0, "owner", "owner", 2),
            new UserEntity(0, "default", "default", 3)
    ));
    private static List<ItemEntity> items = new ArrayList<>(List.of(
            new ItemEntity(1, 10),
            new ItemEntity(2, 20),
            new ItemEntity(3, 30),
            new ItemEntity(4, 40),
            new ItemEntity(5, 50)
    ));

    private final static List<ShopEntity> shops = new ArrayList<>(List.of(
            new ShopEntity(1, 9, 18, "Bucharest", 0, 0, 1)
    ));

    private static List<InventoryEntity> inventoryEntities = new ArrayList<>(List.of(
            new InventoryEntity(1),
            new InventoryEntity(2),
            new InventoryEntity(3)
    ));

    private static List<InventoryItemCrossRef> inventoryItemCrossRefs = new ArrayList<>(List.of(
            new InventoryItemCrossRef(1, 1, 2),
            new InventoryItemCrossRef(1, 2, 3),
            new InventoryItemCrossRef(1, 3, 4),
            new InventoryItemCrossRef(1, 4, 5),
            new InventoryItemCrossRef(1, 5, 6)
    ));

    public static void seed() {
        seedUsers();
        seedItems();
        seedItemInventoryCrossRef();
        seedShops();
        seedInventories();
    }

    public static void seedUsers() {
        for(UserEntity entity: users) {
            userRepository.add(entity);
        }
    }

    public static void seedItems() {
        for(ItemEntity entity: items) {
            itemRepository.addItem(new ItemEntity(entity));
        }
    }

    public static void seedItemInventoryCrossRef() {
        for(InventoryItemCrossRef crossRef: inventoryItemCrossRefs) {
            itemInventoryCrossRefRepository.add(crossRef);
        }
    }

    public static void seedShops() {
        for(ShopEntity shop: shops) {
            shopRepository.addShop(shop);
        }
    }

    public static void seedInventories() {
        for(InventoryEntity entity: inventoryEntities) {
            inventoryRepository.add(entity);
        }
    }



    private Seeder() {}
}
