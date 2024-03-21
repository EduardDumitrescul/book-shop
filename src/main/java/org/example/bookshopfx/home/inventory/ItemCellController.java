package org.example.bookshopfx.home.inventory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.data.models.*;
import org.example.services.ItemService;

public class ItemCellController {

    public Label description;
    private ItemCellModel model = new ItemCellModel();
    private ItemService itemService = ItemService.getInstance();

//    public void setUpdateInventoryCallback(UpdateInventoryCallback updateInventoryCallback) {
//        this.updateInventoryCallback = updateInventoryCallback;
//    }

    public void setItemId(Integer itemId) {
        Item item = itemService.getItem(itemId);
        model.setItem(item);
    }

    @FXML
    public void initialize() {
        description.textProperty().bind(model.descriptionProperty());
    }

    public void viewItem(ActionEvent actionEvent) {
        Item item = model.getItem();
        if(item instanceof Book) {

        }
        else if(item instanceof ColoringBook) {

        }
        else if(item instanceof Notebook) {

        }
        else if(item instanceof Cookbook) {

        }
    }
}
