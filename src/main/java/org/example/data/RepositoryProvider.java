package org.example.data;

import org.example.data.entities.*;
import org.example.data.local.*;
import org.example.data.mysql.*;
import org.example.data.repositories.*;

public class RepositoryProvider {
    private RepositoryProvider() {}

    public static Repository<BookEntity> provideBookRepository() {
        return MySqlBookRepository.getInstance();
    }

    public static Repository<ColoringBookEntity> provideColoringBookRepository() {
        return MySqlColoringBookRepository.getInstance();
    }

    public static Repository<NotebookEntity> provideNotebookRepository() {
        return MySqlNotebookRepository.getInstance();
    }

    public static Repository<CookbookEntity> provideCookbookRepository() {
        return MySqlCookbookRepository.getInstance();
    }

    public static InventoryRepository provideInventoryRepository() {
        return MySqlInventoryRepository.getInstance();
    }

    public static ItemInventoryCrossRefRepository provideItemInventoryCrossRefRepository() {
        return MySqlItemInventoryCrossRefRepository.getInstance();
    }

    public static ItemRepository provideItemRepository() {
        return MySqlItemRepository.getInstance();
    }

    public static ShopRepository provideShopRepository() {
        return MySqlShopRepository.getInstance();
    }

    public static UserRepository provideUserRepository() {
        return MySqlUserRepository.getInstance();
    }
}
