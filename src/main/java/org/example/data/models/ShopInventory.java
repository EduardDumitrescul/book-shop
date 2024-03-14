package org.example.data.models;

import java.util.ArrayList;
import java.util.List;

public class ShopInventory {
    private int id;
    private List<Item> items;

    public ShopInventory(int id, List<Item>items) {
        this.items = cloneItemList(items);
        this.id = id;
    }

    public ShopInventory(ShopInventory obj) {
        this.items = cloneItemList(obj.getItems());
        this.id = obj.getId();
    }

    private List<Item> cloneItemList(List<Item>items) {
        List<Item> list = new ArrayList<>();
        for(Item item: items) {
            list.add(new Item(item));
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public List<Item> getItems() {
        return items;
    }
}
