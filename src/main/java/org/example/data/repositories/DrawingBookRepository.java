package org.example.data.repositories;

import org.example.data.entities.DrawingBookEntity;

public class DrawingBookRepository extends Repository<DrawingBookEntity> {

    private DrawingBookRepository() {
        super();
    }

    private static DrawingBookRepository instance = null;
    public static DrawingBookRepository getInstance() {
        if(instance == null) {
            instance = new DrawingBookRepository();
        }
        return instance;
    }
}
