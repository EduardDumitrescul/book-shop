package org.example.data;

import javafx.scene.paint.Color;
import org.example.data.entities.BookEntity;
import org.example.data.entities.ColoringBookEntity;
import org.example.data.entities.CookbookEntity;
import org.example.data.entities.NotebookEntity;
import org.example.data.local.*;
import org.example.data.repositories.InventoryRepository;
import org.example.data.repositories.ItemInventoryCrossRefRepository;
import org.example.data.repositories.ItemRepository;
import org.example.data.repositories.Repository;

public class RepositoryProvider {
    private RepositoryProvider() {}

    public static Repository<BookEntity> provideBookRepository() {
        return LocalBookRepository.getInstance();
    }

    public static Repository<ColoringBookEntity> provideColoringBookRepository() {
        return LocalColoringBookRepository.getInstance();
    }

    public static Repository<NotebookEntity> provideNotebookRepository() {
        return LocalNotebookRepository.getInstance();
    }

    public static Repository<CookbookEntity> provideCookbookRepository() {
        return LocalCookbookRepository.getInstance();
    }

    public static InventoryRepository provideInventoryRepository() {
        return LocalInventoryRepository.getInstance();
    }

    public static ItemInventoryCrossRefRepository provideItemInventoryCrossRefRepository() {
        return LocalItemInventoryCrossRefRepository.getInstance();
    }

    public static ItemRepository provideItemRepository() {
        return LocalItemRepository.getInstance();
    }
}
