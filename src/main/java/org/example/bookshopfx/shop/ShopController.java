package org.example.bookshopfx.shop;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.data.models.InventoryItem;
import org.example.services.ShopService;

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
}

interface UpdateShopCallback {
    void call();
}
