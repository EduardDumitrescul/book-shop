package org.example.data.models;

public class Item implements Cloneable {
    private final int id;
    private final int price;

    public Item(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public Item(Item obj) {
        this.id = obj.id;
        this.price = obj.price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String description() {
        return "base item";
    }

    @Override
    public Item clone() {
        return new Item(this);
    }
}
