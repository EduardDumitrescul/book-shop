package org.example.ui;

import org.example.services.AccountService;

import static org.example.ui.ConsoleWriter.writeLine;

public class ConsoleApplication {
    private static boolean isRunning = false;
    private static final AccountService accountService = AccountService.getInstance();

    private ConsoleApplication() {}

    public static void show() {
        if (accountService.isLoggedIn()) {
            writeLine("You are logged in");
        } else {
            LoginScreen.show();
        }
    }
}
