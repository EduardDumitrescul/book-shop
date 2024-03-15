package org.example.services;

import org.example.data.entities.BookEntity;
import org.example.data.entities.ColoringBook;
import org.example.data.entities.ItemEntity;
import org.example.data.mappers.ItemMapper;
import org.example.data.models.Item;
import org.example.data.repositories.BookRepository;
import org.example.data.repositories.ColoringBookRepository;
import org.example.data.repositories.ItemRepository;

public class ItemService {
    private ItemRepository itemRepository = ItemRepository.getInstance();
    private BookRepository bookRepository = BookRepository.getInstance();
    private ColoringBookRepository coloringBookRepository = ColoringBookRepository.getInstance();

    public Item getItem(int id) {
        ItemEntity itemEntity = itemRepository.getById(id);
        Item item;

        if(bookRepository.exists(id)) {
            BookEntity bookEntity = bookRepository.getById(id);
            item = ItemMapper.asBook(itemEntity, bookEntity);
        }
        else if(coloringBookRepository.exists(id)) {
            ColoringBook coloringBookEntity = coloringBookRepository.getById(id);
            item = ItemMapper.asDrawingBook(itemEntity, coloringBookEntity);
        }
        else {
            item = ItemMapper.asItem(itemEntity);
        }

        return item;
    }

    private static ItemService instance = null;
    private ItemService() {}

    public static ItemService getInstance() {
        if(instance == null) {
            instance = new ItemService();
        }
        return instance;
    }
}
