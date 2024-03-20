package org.example.bookshopfx.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.data.models.InventoryItem;
import org.example.services.ShopService;
import org.example.services.UserService;

public class ShopItemController {
    private ShopItemModel shopItemModel = new ShopItemModel();
    private ShopService shopService = ShopService.getInstance();
    private UserService userService = UserService.getInstance();

    private UpdateShopCallback updateShopCallback = null;
    @FXML
    public Label text;
    public Label price;
    public Label stock;

    public void setInventoryItem(InventoryItem inventoryItem) {
        shopItemModel.setInventoryItem(inventoryItem);
    }

    public void setUpdateShopCallback(UpdateShopCallback updateShopCallback) {
        this.updateShopCallback = updateShopCallback;
    }

    public void buy(ActionEvent actionEvent) {
        int userId = userService.getCurrentUser().getId();
        int itemId = shopItemModel.getInventoryItem().getItem().getId();
        shopService.buyItem(userId, itemId);
        try {
            updateShopCallback.call();
        } catch (Exception ignored) {

        }

    }

    @FXML
    public void initialize() {
        text.textProperty().bind(shopItemModel.descriptionProperty());
        price.textProperty().bind(shopItemModel.priceProperty());
        stock.textProperty().bind(shopItemModel.stockProperty());
    }
}
