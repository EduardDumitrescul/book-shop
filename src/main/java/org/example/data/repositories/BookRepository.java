package org.example.data.repositories;

import org.example.data.entities.BookEntity;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private List<BookEntity> books = new ArrayList<>();

    public int add(BookEntity entity) {
        generateId(entity);
        books.add(entity.clone());
        return entity.id;
    }

    public boolean exists(int id) {
        for(BookEntity entity: books) {
            if(entity.id == id) {
                return true;
            }
        }
        return false;
    }

    public BookEntity getById(int id) {
        for(BookEntity bookEntity: books) {
            if(bookEntity.id == id) {
                return bookEntity.clone();
            }
        }
        return null;
    }

    public void update(BookEntity entity) {
        int index = books.indexOf(entity);
        books.set(index, entity.clone());
    }

    public void delete(BookEntity entity) {
        books.remove(entity);
    }

    private static int idCount = 0;
    private void generateId(BookEntity entity) {
        idCount ++;
        entity.id = idCount;
    }

    private static BookRepository instance = null;
    private BookRepository() {}

    public static BookRepository getInstance() {
        if(instance == null) {
            instance = new BookRepository();
        }
        return instance;
    }
}
