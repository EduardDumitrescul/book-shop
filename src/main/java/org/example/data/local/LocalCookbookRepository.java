package org.example.data.local;

import org.example.data.entities.CookbookEntity;

public class LocalCookbookRepository extends LocalRepository<CookbookEntity> {


    private LocalCookbookRepository() {
        super();
    }
    private static LocalCookbookRepository instance = null;

    public static LocalCookbookRepository getInstance() {
        if(instance == null) {
            instance = new LocalCookbookRepository();
        }
        return instance;
    }
}
