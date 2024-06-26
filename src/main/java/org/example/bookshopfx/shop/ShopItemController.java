package org.example.bookshopfx.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.data.models.InventoryItem;
import org.example.services.AuditService;
import org.example.services.ShopService;
import org.example.services.UserService;

public class ShopItemController {
    public Button restockButton;
    private final ShopItemModel shopItemModel = new ShopItemModel();
    private final ShopService shopService = ShopService.getInstance();
    private final UserService userService = UserService.getInstance();

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
        AuditService.log(AuditService.Action.BUY_ITEM);
        try {
            updateShopCallback.call();
        } catch (Exception ignored) {

        }

    }
    public void restock(ActionEvent actionEvent) {
        int itemId = shopItemModel.getInventoryItem().getItem().getId();
        shopService.addItemToShopInventory(itemId);
        updateShopCallback.call();
        AuditService.log(AuditService.Action.RESTOCK_SHOP);
    }

    @FXML
    public void initialize() {
        text.textProperty().bind(shopItemModel.descriptionProperty());
        price.textProperty().bind(shopItemModel.priceProperty());
        stock.textProperty().bind(shopItemModel.stockProperty());

        boolean isOwner = shopService.isOwner(userService.getCurrentUser().getId());
        restockButton.setVisible(isOwner);
    }
}
