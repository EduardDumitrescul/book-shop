package org.example.data;

import org.example.data.entities.*;
import org.example.data.local.*;
import org.example.data.models.*;
import org.example.data.repositories.*;
import org.example.services.ItemService;
import org.example.services.ShopService;
import org.example.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class Seeder {
    private static final UserService userService = UserService.getInstance();
    private static final ShopService shopService = ShopService.getInstance();
    private static final ItemService itemService = ItemService.getInstance();
    private static final ItemRepository itemRepository = RepositoryProvider.provideItemRepository();
    private static final Repository<BookEntity> bookRepository = RepositoryProvider.provideBookRepository();
    private static final Repository<ColoringBookEntity> coloringBookRepository = RepositoryProvider.provideColoringBookRepository();
    private static final Repository<NotebookEntity> notebookRepository = RepositoryProvider.provideNotebookRepository();

    private static final Repository<CookbookEntity> cookbookRepository = RepositoryProvider.provideCookbookRepository();
    private static final ShopRepository shopRepository = RepositoryProvider.provideShopRepository();
    private static final InventoryRepository inventoryRepository = RepositoryProvider.provideInventoryRepository();
    private static final ItemInventoryCrossRefRepository itemInventoryCrossRefRepository = RepositoryProvider.provideItemInventoryCrossRefRepository();
    private static final UserRepository userRepository = RepositoryProvider.provideUserRepository();

    private static final List<UserEntity> users = new ArrayList<>(List.of(
            new UserEntity(0, "owner", "owner", 2),
            new UserEntity(0, "default", "default", 3)
    ));
    private static final List<ItemEntity> items = new ArrayList<>(List.of(
            new ItemEntity(1, 10),
            new ItemEntity(2, 20),
            new ItemEntity(3, 30),
            new ItemEntity(4, 40),
            new ItemEntity(5, 50)
    ));

    private static final List<BookEntity> books = new ArrayList<>(List.of(
            new BookEntity(1, "title 1", "author 1", 100, 0)
    ));
    private static final List<ColoringBookEntity> drawingBooks = new ArrayList<>(List.of(
            new ColoringBookEntity(2, "title 1", 100, 0)
    ));
    private static final List<NotebookEntity> notebooks = new ArrayList<>(List.of(
            new NotebookEntity(3, "lined", 100, 0)
    ));
    private static final List<CookbookEntity> cookbooks = new ArrayList<>(List.of(
            new CookbookEntity(4, "beginner", 100, 0)
    ));

    private final static List<ShopEntity> shops = new ArrayList<>(List.of(
            new ShopEntity(1, 9, 18, "Bucharest", 0, 0, 1, 1)
    ));

    private static final List<InventoryEntity> inventoryEntities = new ArrayList<>(List.of(
            new InventoryEntity(1),
            new InventoryEntity(2),
            new InventoryEntity(3)
    ));

    private static final List<InventoryItemCrossRef> inventoryItemCrossRefs = new ArrayList<>(List.of(
            new InventoryItemCrossRef(1, 1, 2),
            new InventoryItemCrossRef(1, 2, 3),
            new InventoryItemCrossRef(1, 3, 4),
            new InventoryItemCrossRef(1, 4, 5),
            new InventoryItemCrossRef(1, 5, 6)
    ));

    public static void seed() {
        seedUsers();
        seedItems();
        seedBooks();
        seedDrawingBooks();
        seedNotebooks();
        seedCookbooks();
        seedItemInventoryCrossRef();
        seedShops();
        seedInventories();
    }

    public static void seedDB() throws Exception {
        try {
            userService.register("default", "123456");
            userService.register("owner", "123456");
        }
        catch (Exception ignored) {

        }

        int ownerId = 2;

        shopService.addShop(new ShopEntity(1, 9, 20, "Bucharest", 0, 0, 0, ownerId));
        List<Item> items = new ArrayList<>(List.of(
                new Book(0, 20, "The Quantum Teacup", "Professor Aetherius Quixley", 256, 0),
                new Book(0, 13, "Chronicles of the Moonfruit Bakery", "Penelope Whiskerbottom", 312, 0),
                new Book(0, 17, "The Enigma of the Polka-Dotted Umbrella", "Jasper Puddlefrost", 400, 0),
                new Book(0, 25, "Whispers from the Cosmic Teapot", "Zara Stardust", 512, 0),
                new Book(0, 10, "The Secret Lives of Library Bookmarks", "Miss Marigold Dewey", 192, 0),
                new ColoringBook(0, 12, "Fantasy", 20, 0),
                new ColoringBook(1, 120, "Animals", 15, 0),
                new ColoringBook(2, 14, "Underwater", 18, 0),
                new ColoringBook(3, 20, "Space Adventures", 25, 0),
                new ColoringBook(4, 16, "Magical Creatures", 22, 0),
                new Cookbook(1, 20, "Beginner", 50, 0),
                new Cookbook(2, 25, "Intermediate", 75, 0),
                new Cookbook(3, 30, "Advanced", 100, 0),
                new Cookbook(4, 15, "Beginner", 40, 0),
                new Cookbook(5, 35, "Advanced", 120, 0),
                new Notebook(1, 5, "A4", 100, 0),
                new Notebook(2, 7, "A5", 150, 0),
                new Notebook(3, 4, "B5", 120, 0),
                new Notebook(4, 8, "A4", 200, 0),
                new Notebook(5, 3, "B6", 80, 0)
                )
        );

        items.forEach(item -> {
            int id = itemService.addItem(item);
            shopService.addItemToShopInventory(id, 1);
        });
    }

    public static void seedUsers() {
        for(UserEntity entity: users) {
            userRepository.add(entity);
        }
    }

    public static void seedItems() {
        for(ItemEntity entity: items) {
            itemRepository.addItem(new ItemEntity(entity));
        }
    }

    public static void seedBooks() {
        for(BookEntity entity: books) {
            bookRepository.add(new BookEntity(entity));
        }
    }

    public static void seedDrawingBooks() {
        for(ColoringBookEntity entity: drawingBooks) {
            coloringBookRepository.add(new ColoringBookEntity(entity));
        }
    }
    public static void seedNotebooks() {
        for(NotebookEntity entity: notebooks) {
            notebookRepository.add(new NotebookEntity(entity));
        }
    }
    public static void seedCookbooks() {
        for(CookbookEntity entity: cookbooks) {
            cookbookRepository.add(new CookbookEntity(entity));
        }
    }

    public static void seedItemInventoryCrossRef() {
        for(InventoryItemCrossRef crossRef: inventoryItemCrossRefs) {
            itemInventoryCrossRefRepository.add(crossRef);
        }
    }

    public static void seedShops() {
        for(ShopEntity shop: shops) {
            shopRepository.addShop(shop);
        }
    }

    public static void seedInventories() {
        for(InventoryEntity entity: inventoryEntities) {
            inventoryRepository.add(entity);
        }
    }



    private Seeder() {}
}
