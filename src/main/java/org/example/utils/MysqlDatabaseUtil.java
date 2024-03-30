package org.example.utils;

import org.example.data.entities.ShopEntity;
import org.example.data.models.*;
import org.example.data.mysql.MySqlConnection;
import org.example.services.ItemService;
import org.example.services.ShopService;
import org.example.services.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MysqlDatabaseUtil {
    private static Connection connection = MySqlConnection.getConnection();
    private static ItemService itemService = ItemService.getInstance();
    private static UserService userService = UserService.getInstance();
    private static ShopService shopService = ShopService.getInstance();
    public static void main(String[] args) throws Exception {
        reset();
    }

    private static void reset() throws Exception {
        executeFile("./documentation/mysql/1-drop-tables.sql");
        executeFile("./documentation/mysql/2-create-tables.sql");
        seedDB();
    }

    private static void executeFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String comm = scanner.nextLine();
                if (comm.isEmpty()) {
                    continue;
                }
                try {
                    PreparedStatement statement = connection.prepareStatement(comm);
                    statement.execute();
                }
                catch (Exception e) {

                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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

}
