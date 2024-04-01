package org.example.data.models;

public class InventoryItem implements Cloneable {
    private final Item item;
    private final int count;

    public InventoryItem(Item item, int count) {
        this.item = item.clone();
        this.count = count;
    }

    public InventoryItem(InventoryItem obj) {
        this.item = obj.item.clone();
        this.count = obj.count;
    }

    public Item getItem() {
        return item.clone();
    }

    public int getCount() {
        return count;
    }

    @Override
    public Cloneable clone() {
        return new InventoryItem(this);
    }
}
