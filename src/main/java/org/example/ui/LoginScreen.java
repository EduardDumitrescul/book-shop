package org.example.ui;

import org.example.services.AccountService;

import static org.example.ui.ConsoleReader.readLine;
import static org.example.ui.ConsoleWriter.write;
import static org.example.ui.ConsoleWriter.writeLine;

public class LoginScreen {
    static boolean running = false;
    static AccountService accountService = AccountService.getInstance();

    public static void show() {
        running = true;
        while(running) {
            writeLine("Please login into your account.");
            String command = readLine();
            switch (command) {
                case "register" -> registerView();
                case "login" -> loginView();
            }
        }
    }

    private static String requireUsername() {
        write("Username: ");
        return readLine();
    }

    private static String requirePassword() {
        write("Password: ");
        return readLine();
    }

    private static void registerView() {
        String username = requireUsername();
        String password = requirePassword();
        try {
            accountService.register(username, password);
            running = false;
        } catch (Exception e) {
            writeLine(e.getMessage());
        }
    }

    private static void loginView() {

    }
}
