package org.example.services;

import org.example.data.entities.*;
import org.example.data.mappers.ItemMapper;
import org.example.data.models.*;
import org.example.data.repositories.*;

public class ItemService {
    private ItemRepository itemRepository = ItemRepository.getInstance();
    private BookRepository bookRepository = BookRepository.getInstance();
    private ColoringBookRepository coloringBookRepository = ColoringBookRepository.getInstance();
    private NotebookRepository notebookRepository = NotebookRepository.getInstance();

    private CookbookRepository cookbookRepository = CookbookRepository.getInstance();

    public Item getItem(int id) {
        ItemEntity itemEntity = itemRepository.getById(id);
        Item item;

        if(bookRepository.exists(id)) {
            BookEntity bookEntity = bookRepository.getById(id);
            item = ItemMapper.asBook(itemEntity, bookEntity);
        }
        else if(coloringBookRepository.exists(id)) {
            ColoringBookEntity coloringBookEntity = coloringBookRepository.getById(id);
            item = ItemMapper.asDrawingBook(itemEntity, coloringBookEntity);
        }
        else if(notebookRepository.exists(id)) {
            NotebookEntity notebookEntity = notebookRepository.getById(id);
            item = ItemMapper.asNotebook(itemEntity, notebookEntity);
        }
        else if(cookbookRepository.exists(id)) {
            CookbookEntity cookbookEntity = cookbookRepository.getById(id);
            item = ItemMapper.asCookbook(itemEntity, cookbookEntity);
        }
        else {
            item = ItemMapper.asItem(itemEntity);
        }

        return item;
    }

    public int addItem(Item item) {
        ItemEntity itemEntity = ItemMapper.asEntity(item);
        int id = itemRepository.addItem(itemEntity);

        if(item instanceof Book) {
            BookEntity bookEntity = ItemMapper.asEntity((Book)item);
            bookEntity.id = id;
            bookRepository.add(bookEntity);
        }
        if(item instanceof ColoringBook) {
            ColoringBookEntity coloringBookEntity = ItemMapper.asEntity((ColoringBook)item);
            coloringBookEntity.id = id;
            coloringBookRepository.add(coloringBookEntity);
        }
        if(item instanceof Notebook) {
            NotebookEntity notebookEntity = ItemMapper.asEntity((Notebook)item);
            notebookEntity.id = id;
            notebookRepository.add(notebookEntity);
        }
        if(item instanceof Cookbook) {
            CookbookEntity cookbookEntity = ItemMapper.asEntity((Cookbook)item);
            cookbookEntity.id = id;
            cookbookRepository.add(cookbookEntity);
        }
        return id;
    }

    public void updateItem(Item item) {
        ItemEntity itemEntity = ItemMapper.asEntity(item);
        if(item instanceof Book) {
            BookEntity bookEntity = ItemMapper.asEntity((Book)item);
            bookRepository.update(bookEntity);
        }
        else if(item instanceof ColoringBook) {
            ColoringBookEntity coloringBook = ItemMapper.asEntity((ColoringBook) item);
            coloringBookRepository.update(coloringBook);
        }
        itemRepository.update(itemEntity);
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
