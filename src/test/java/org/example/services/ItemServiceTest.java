package org.example.services;

import org.example.data.Seeder;
import org.example.data.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemServiceTest {
    private ItemService itemService = ItemService.getInstance();

    @BeforeEach
    public void setUp() {
        Seeder.seed();
    }
    @Test
    void getItem() {
        Item item = itemService.getItem(1);
        System.out.println(item);
    }
}