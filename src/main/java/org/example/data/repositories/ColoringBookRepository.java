package org.example.data.repositories;

import org.example.data.entities.ColoringBook;

public class ColoringBookRepository extends Repository<ColoringBook> {

    private ColoringBookRepository() {
        super();
    }

    private static ColoringBookRepository instance = null;
    public static ColoringBookRepository getInstance() {
        if(instance == null) {
            instance = new ColoringBookRepository();
        }
        return instance;
    }
}
