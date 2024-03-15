package org.example.services;

import org.example.data.Seeder;
import org.example.data.models.Book;
import org.example.data.models.ColoringBook;
import org.example.data.models.Item;
import org.example.data.models.Notebook;
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
        Item item = itemService.getItem(3);
        if(item instanceof Book) {
            System.out.println("book");
        }
        else if(item instanceof ColoringBook) {
            System.out.println("drawing book");
        }
        else if(item instanceof Notebook) {
            System.out.println("notebook");
        }
        else {
            System.out.println("item");
        }
    }
}