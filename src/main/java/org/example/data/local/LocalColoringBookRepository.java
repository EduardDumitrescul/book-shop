package org.example.data.local;

import org.example.data.entities.ColoringBookEntity;

public class LocalColoringBookRepository extends LocalRepository<ColoringBookEntity> {

    private LocalColoringBookRepository() {
        super();
    }

    private static LocalColoringBookRepository instance = null;
    public static LocalColoringBookRepository getInstance() {
        if(instance == null) {
            instance = new LocalColoringBookRepository();
        }
        return instance;
    }
}
