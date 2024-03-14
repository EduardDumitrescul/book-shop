package org.example.data.entities;

public class ShopEntity {
    int id;
    int openingHour;
    int closingHour;
    String location;
    int itemsSold;
    int dollarsReceived;

    int inventoryId;

    public ShopEntity(
            int id,
            int openingHour,
            int closingHour,
            String location,
            int itemsSold,
            int dollarsReceived,
            int inventoryId
    ) {
        this.id = id;
        this.openingHour = openingHour;
        this.closingHour = closingHour;
        this.location = location;
        this.itemsSold = itemsSold;
        this.dollarsReceived = dollarsReceived;
        this.inventoryId = inventoryId;
    }

    public ShopEntity(ShopEntity obj) {
        this.id = obj.id;
        this.openingHour = obj.openingHour;
        this.closingHour = obj.closingHour;
        this.location = obj.location;
        this.itemsSold = obj.itemsSold;
        this.dollarsReceived = obj.dollarsReceived;
        this.inventoryId = obj.inventoryId;
    }
}
