package org.example.bookshopfx.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.models.Cookbook;
import org.example.services.AuditService;
import org.example.services.ItemService;

import java.util.List;

public class ViewCookbookController {
    private ItemService itemService = ItemService.getInstance();
    private ViewCookbookModel model = new ViewCookbookModel();
    public Label skill;
    public Label recipes;
    public Label recipesTried;

    @FXML
    private void initialize() {
        List<String> args = NavigationController.getInstance().getArguments();
        int itemId = Integer.parseInt(args.get(0));
        Cookbook cookbook = (Cookbook) itemService.getItem(itemId);
        model.setCookbook(cookbook);

        skill.textProperty().bind(model.skillProperty());
        recipes.textProperty().bind(model.recipesProperty());
        recipesTried.textProperty().bind(model.recipesTriedProperty());
    }

    public void back(ActionEvent actionEvent) {
        navigateBack();
    }

    public void cook(ActionEvent actionEvent) {
        try {
            Cookbook cookbook = model.getCookbook();
            cookbook.cook();
            itemService.updateItem(cookbook);
            model.setCookbook((Cookbook) itemService.getItem(cookbook.getId()));

            AuditService.log(AuditService.Action.USE_OWNED_ITEM);
        } catch (Exception ignored) {

        }
    }

    private void navigateBack() {
        NavigationController.getInstance().navigateBack();
    }

    public void throwAway(ActionEvent actionEvent) {
        int itemId = model.getCookbook().getId();
        itemService.throwAwayItem(itemId);
        navigateBack();

        AuditService.log(AuditService.Action.THROW_AWAY_ITEM);
    }
}
