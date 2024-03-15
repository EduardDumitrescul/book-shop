package org.example.data;

import org.example.data.entities.InventoryEntity;
import org.example.data.entities.InventoryItemCrossRef;
import org.example.data.entities.ItemEntity;
import org.example.data.entities.ShopEntity;
import org.example.data.repositories.ItemInventoryCrossRefRepository;
import org.example.data.repositories.ItemRepository;
import org.example.data.repositories.ShopInventoryRepository;
import org.example.data.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

public class Seeder {
    private static ItemRepository itemRepository = ItemRepository.getInstance();
    private static ShopRepository shopRepository = ShopRepository.getInstance();
    private static ShopInventoryRepository shopInventoryRepository = ShopInventoryRepository.getInstance();
    private static ItemInventoryCrossRefRepository itemInventoryCrossRefRepository = ItemInventoryCrossRefRepository.getInstance();

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

    private static List<InventoryEntity> shopInventories = new ArrayList<>(List.of(
            new InventoryEntity(1)
    ));

    private static List<InventoryItemCrossRef> inventoryItemCrossRefs = new ArrayList<>(List.of(
            new InventoryItemCrossRef(1, 1, 2),
            new InventoryItemCrossRef(1, 2, 3),
            new InventoryItemCrossRef(1, 3, 4),
            new InventoryItemCrossRef(1, 4, 5),
            new InventoryItemCrossRef(1, 5, 6)
    ));

    public static void seed() {
        seedItems();
        seedItemInventoryCrossRef();
        seedShops();
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



    private Seeder() {}
}
