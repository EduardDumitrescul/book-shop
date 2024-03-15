package org.example.services;

import org.example.data.Seeder;
import org.example.data.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ShopServiceTest {
    private ShopService shopService = ShopService.getInstance();

    @BeforeEach
    void setUp() {
        Seeder.seed();
    }

    @Test
    void getItemsByInventoryIdTest() {
        List<Item> items = shopService.getItemsByInventoryId(1);
        System.out.println(items);
    }
    @Test
    void getAllItem() {
        List<Item> items = shopService.getAllItems();
        System.out.println(items);
    }
}