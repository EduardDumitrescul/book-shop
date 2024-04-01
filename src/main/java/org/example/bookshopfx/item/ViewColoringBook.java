package org.example.bookshopfx.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.models.ColoringBook;
import org.example.data.models.Item;
import org.example.services.AuditService;
import org.example.services.ItemService;

import java.util.List;

public class ViewColoringBook {
    private ItemService itemService = ItemService.getInstance();
    private ViewColoringBookModel model = new ViewColoringBookModel();
    public Label theme;
    public Label totalDrawings;
    public Label drawingsCompleted;


    @FXML
    private void initialize() {
        List<String> args = NavigationController.getInstance().getArguments();
        ColoringBook coloringBook = (ColoringBook) itemService.getItem(Integer.parseInt(args.get(0)));
        model.setColoringBook(coloringBook);

        theme.textProperty().bind(model.themeProperty());
        totalDrawings.textProperty().bind(model.totalDrawingsProperty());
        drawingsCompleted.textProperty().bind(model.drawingsCompletedProperty());
    }

    public void back(ActionEvent actionEvent) {
        navigateBack();
    }

    public void draw(ActionEvent actionEvent) {
        try {
            ColoringBook coloringBook = model.getColoringBook();
            coloringBook.draw();
            itemService.updateItem(coloringBook);
            model.setColoringBook((ColoringBook) itemService.getItem(coloringBook.getId()));
            AuditService.log(AuditService.Action.USE_OWNED_ITEM);
        } catch (Exception ignored) {
        }
    }

    private void navigateBack() {
        NavigationController.getInstance().navigateBack();
    }

    public void throwAway(ActionEvent actionEvent) {
        int itemId = model.getColoringBook().getId();
        itemService.throwAwayItem(itemId);
        navigateBack();

        AuditService.log(AuditService.Action.THROW_AWAY_ITEM);
    }
}
