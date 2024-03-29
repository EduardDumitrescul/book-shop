package org.example.data;

import javafx.scene.paint.Color;
import org.example.data.entities.*;
import org.example.data.local.*;
import org.example.data.repositories.*;

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

    public static ShopRepository provideShopRepository() {
        return LocalShopRepository.getInstance();
    }
}
