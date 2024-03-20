package org.example.bookshopfx.shop;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.example.data.models.Shop;
import org.example.services.ShopService;

public class ShopController {
    private ShopModel shopModel = new ShopModel();
    private ShopService shopService = ShopService.getInstance();
    @FXML
    public ListView<String> itemListView;

    @FXML
    public void initialize() {
        shopModel.setShop(shopService.getShop());
        itemListView.setItems(shopModel.getItemList());
    }
}
