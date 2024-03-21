package org.example.bookshopfx.home.inventory;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import org.example.bookshopfx.HelloApplication;

import java.io.IOException;

public class ItemCell extends ListCell<Integer> {
    private HBox root;

    private ItemCellController controller;


    public ItemCell() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home/item.fxml"));
            root = fxmlLoader.load();
            controller = fxmlLoader.getController();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void updateItem(Integer itemId, boolean empty) {
        super.updateItem(itemId, empty);
        if(empty) {
            setGraphic(null);
        }
        else {
            controller.setItemId(itemId);
            setGraphic(root);
        }
    }
}
