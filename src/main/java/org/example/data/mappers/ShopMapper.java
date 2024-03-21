package org.example.data.mappers;

import org.example.data.entities.ShopEntity;
import org.example.data.models.Shop;
import org.example.data.models.ShopInventory;

public class ShopMapper {
    private ShopMapper() {}

    public static Shop asShop(ShopEntity entity, ShopInventory inventory) {
        return new Shop(
                entity.id,
                entity.openingHour,
                entity.closingHour,
                entity.location,
                entity.itemsSold,
                entity.dollarsReceived,
                entity.ownerId,
                inventory
        );
    }
}
