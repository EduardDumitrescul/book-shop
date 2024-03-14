package org.example.data.repositories;

import org.example.data.entities.ShopEntity;

import java.util.ArrayList;
import java.util.List;

public class ShopRepository {
    private List<ShopEntity> shops = new ArrayList<>();


    public ShopEntity getById(int id) {
        for(ShopEntity entity: shops) {
            if(entity.getId() == id) {
                return new ShopEntity(entity);
            }
        }
        return null;
    }



    private ShopRepository() {}

    private static ShopRepository instance;

    public static  ShopRepository getInstance() {
        if(instance == null) {
            instance = new ShopRepository();
        }
        return instance;
    }
}
