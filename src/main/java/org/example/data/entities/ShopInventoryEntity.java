package org.example.data.entities;

public class ShopInventoryEntity {
    int id;

    public ShopInventoryEntity(
            int id
    ) {
        this.id = id;
    }

    public ShopInventoryEntity(ShopInventoryEntity obj) {
        this.id = obj.id;
    }
}
