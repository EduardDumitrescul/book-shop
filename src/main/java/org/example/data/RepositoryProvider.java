package org.example.data;

import org.example.data.entities.BookEntity;
import org.example.data.local.LocalBookRepository;
import org.example.data.repositories.Repository;

public class RepositoryProvider {
    private RepositoryProvider() {}

    public static Repository<BookEntity> provideBookRepository() {
        return LocalBookRepository.getInstance();
    }
}
