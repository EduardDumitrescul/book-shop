package org.example.bookshopfx.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.models.InventoryItem;
import org.example.services.ShopService;

import java.util.List;

public class ShopController implements UpdateShopCallback {
    private ShopModel shopModel = new ShopModel();
    private ShopService shopService = ShopService.getInstance();
    @FXML
    public ListView<InventoryItem> itemListView;

    @FXML
    public void initialize() {
        setupModel();
    }

    private void setupModel() {
        shopModel.setShop(shopService.getShop());
        itemListView.refresh();
        itemListView.setItems(shopModel.getItemList());
        itemListView.setCellFactory(listView -> new ShopItemCell(this));
    }

    @Override
    public void call() {
        setupModel();
    }

    public void back(ActionEvent actionEvent) {
        NavigationController.getInstance().showScreen("home", List.of());
    }
}

interface UpdateShopCallback {
    void call();
}
