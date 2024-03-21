package org.example.data.models;

import org.example.data.mappers.ItemMapper;
import org.example.utils.ObjectCloningUtil;

import java.util.List;

public class UserInventory implements Cloneable {
    private int id;

    private List<Item> items;

    public UserInventory(int id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    public UserInventory(UserInventory obj) {
        this.id = obj.id;
        this.items = obj.items;
    }

    public int getNumberOfBooks() {
        int count = 0;
        for(Item item: items) {
            if(item instanceof Book) {
                count += 1;
            }
        }
        return count;
    }
    public int getNumberOfColoringBooks() {
        int count = 0;
        for(Item item: items) {
            if(item instanceof ColoringBook) {
                count += 1;
            }
        }
        return count;
    }
    public int getNumberOfNotebooks() {
        int count = 0;
        for(Item item: items) {
            if(item instanceof Notebook) {
                count += 1;
            }
        }
        return count;
    }
    public int getNumberOfCookbooks() {
        int count = 0;
        for(Item item: items) {
            if(item instanceof Cookbook) {
                count += 1;
            }
        }
        return count;
    }

    public List<Item> getItems() {
        return items.stream().map(Item::new).toList();
    }

    @Override
    public Cloneable clone() {
        return new UserInventory(this);
    }
}
