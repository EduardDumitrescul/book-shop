module org.example.bookshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires mysql.connector.j;
    requires opencsv;

    opens org.example.bookshopfx to javafx.fxml;
    opens org.example.bookshopfx.login to javafx.fxml;
    opens org.example.bookshopfx.home to javafx.fxml;
    opens org.example.bookshopfx.shop to javafx.fxml;
    exports org.example.bookshopfx;
    exports org.example.bookshopfx.navigation;
    opens org.example.bookshopfx.navigation to javafx.fxml;
    opens org.example.bookshopfx.home.inventory to javafx.fxml;
    opens org.example.bookshopfx.item to javafx.fxml;
}