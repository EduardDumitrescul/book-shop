package org.example.services;

import org.example.data.Seeder;
import org.example.data.models.Book;
import org.example.data.models.DrawingBook;
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
        Item item = itemService.getItem(2);
        if(item instanceof Book) {
            System.out.println("book");
        }
        else if(item instanceof DrawingBook) {
            System.out.println("drawing book");
        }
        else {
            System.out.println("item");
        }
    }
}