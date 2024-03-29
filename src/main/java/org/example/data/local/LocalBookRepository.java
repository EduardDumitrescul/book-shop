package org.example.data.local;

import org.example.data.entities.BookEntity;

public class LocalBookRepository extends LocalRepository<BookEntity> {

    private LocalBookRepository() {}

    private static LocalBookRepository instance = null;
    public static LocalBookRepository getInstance() {
        if(instance == null) {
            instance = new LocalBookRepository();
        }
        return instance;
    }
}
