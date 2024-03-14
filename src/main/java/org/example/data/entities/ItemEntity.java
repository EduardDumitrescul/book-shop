package org.example.data.entities;

public class ItemEntity {
    int id;
    int price;

    public ItemEntity(
            int id,
            int price
    ) {
        this.id  = id;
        this.price = price;
    }

    public ItemEntity(ItemEntity obj) {
        this.id = obj.id;
        this.price = obj.price;
    }
}
