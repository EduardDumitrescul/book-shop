package org.example.data.repositories;

import org.example.data.entities.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private List<ItemEntity> items = new ArrayList<>();


    private static ItemRepository instance = null;

    private ItemRepository() {}

    public static ItemRepository getInstance()   {
        if(instance == null) {
            instance = new ItemRepository();
        }
        return instance;
    }
}
