package org.example.data.entities;

import org.example.data.Cloneable;

public class ShopInventoryEntity implements Cloneable {
    int id;

    public ShopInventoryEntity(
            int id
    ) {
        this.id = id;
    }


    public ShopInventoryEntity(ShopInventoryEntity obj) {
        this.id = obj.id;
    }

    @Override
    public ShopInventoryEntity clone() {
        return new ShopInventoryEntity(this);
    }

    public int getId() {
        return id;
    }
}
