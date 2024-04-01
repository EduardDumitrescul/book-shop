package org.example.data.models;

public class Shop implements Cloneable {
    private final int id;
    private final int openingHour;
    private final int closingHour;
    private final String location;
    private final int itemsSold;
    private final int dollarsReceived;

    private final int ownerId;

    private final ShopInventory inventory;

    public Shop(
            int id,
            int openingHour,
            int closingHour,
            String location,
            int itemsSold,
            int dollarsReceived,
            int ownerId,
            ShopInventory inventory
    ) {
        this.id = id;
        this.closingHour = closingHour;
        this.openingHour = openingHour;
        this.location = location;
        this.itemsSold = itemsSold;
        this.dollarsReceived = dollarsReceived;
        this.ownerId = ownerId;
        this.inventory = new ShopInventory(inventory);
    }

    public Shop(Shop obj) {
        this.id = obj.id;
        this.location = obj.location;
        this.itemsSold = obj.itemsSold;
        this.openingHour = obj.openingHour;
        this.dollarsReceived = obj.dollarsReceived;
        this.closingHour = obj.closingHour;
        this.ownerId = obj.ownerId;
        this.inventory = new ShopInventory(obj.inventory);
    }

    public int getId() {
        return id;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public int getDollarsReceived() {
        return dollarsReceived;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public ShopInventory getInventory() {
        return new ShopInventory(inventory);
    }

    public String getLocation() {
        return location;
    }

    public int getOwnerId() {
        return ownerId;
    }

    @Override
    public Shop clone() {
        return new Shop(this);
    }
}
