package org.example.data.repositories;

import org.example.data.entities.ShopEntity;

import java.util.ArrayList;
import java.util.List;

public class ShopRepository {
    private List<ShopEntity> shops = new ArrayList<>();

    private ShopRepository() {}

    private static ShopRepository instance;

    public static  ShopRepository getInstance() {
        if(instance == null) {
            instance = new ShopRepository();
        }
        return instance;
    }
}
