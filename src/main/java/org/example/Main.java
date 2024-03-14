package org.example;

import org.example.data.Seeder;
import org.example.ui.ConsoleApplication;

public class Main {
    public static void main(String[] args) {
        Seeder.seedItems();


        ConsoleApplication.show();
    }
}