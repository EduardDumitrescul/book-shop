module org.example.bookshopfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens org.example.bookshopfx to javafx.fxml;
    opens org.example.bookshopfx.login to javafx.fxml;
    opens org.example.bookshopfx.home to javafx.fxml;
    exports org.example.bookshopfx;
}