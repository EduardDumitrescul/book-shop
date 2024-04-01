package org.example.data.local;

import org.example.data.entities.ShopEntity;
import org.example.data.repositories.ShopRepository;

import java.util.ArrayList;
import java.util.List;

public class LocalShopRepository implements ShopRepository {
    private final List<ShopEntity> shops = new ArrayList<>();


    public ShopEntity getById(int id) {
        for(ShopEntity entity: shops) {
            if(entity.getId() == id) {
                return new ShopEntity(entity);
            }
        }


        return null;
    }

    public void addShop(ShopEntity shop) {
        generateId(shop);
        shops.add(shop);
    }


    private static int idCount = 0;
    private void generateId(ShopEntity shop) {
        idCount ++;
        shop.id = idCount;
    }

    private LocalShopRepository() {}

    private static LocalShopRepository instance;

    public static LocalShopRepository getInstance() {
        if(instance == null) {
            instance = new LocalShopRepository();
        }
        return instance;
    }
}
