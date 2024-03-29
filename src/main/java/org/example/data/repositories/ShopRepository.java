package org.example.data.repositories;

import org.example.data.entities.ShopEntity;

public interface ShopRepository {
    ShopEntity getById(int id);

    void addShop(ShopEntity shop);
}
