package org.example.services;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AuditService {
    private static final Map<String, Integer> usage = new HashMap<>();

    public static void init() {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader("audit.csv"));
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null)
            {
                usage.put(nextLine[0], Integer.valueOf(nextLine[1].strip()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("./audit.csv"))) {
            for(Map.Entry<String, Integer> entry: usage.entrySet()) {
                String[] line = {entry.getKey(), String.valueOf(entry.getValue())};
                writer.writeNext(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void log(Action action) {
        int count = usage.get(action.getAction());
        usage.put(action.getAction(), count + 1);
    }


    public static void main(String[] args) {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader("./audit.csv"));
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null)
            {
                for(String token : nextLine)
                {
                    System.out.print(token);
                }
                System.out.print("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public enum Action {
        REGISTER("register"),
        LOGIN("login"),
        LOGOUT("logout"),
        VIEW_SHOP_INVENTORY("view shop inventory"),
        RESTOCK_SHOP("restock shop"),
        BUY_ITEM("buy item"),
        VIEW_ITEM_DETAILS("view item details"),
        VIEW_USER_INVENTORY("view user inventory"),
        USE_OWNED_ITEM("use owned item"),
        THROW_AWAY_ITEM("throw away item"),
         ;


        private String action;
        Action(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }
}
