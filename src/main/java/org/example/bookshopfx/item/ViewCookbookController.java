package org.example.bookshopfx.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.models.Cookbook;
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
        NavigationController.getInstance().navigateBack();
    }

    public void cook(ActionEvent actionEvent) {
        try {
            Cookbook cookbook = model.getCookbook();
            cookbook.cook();
            itemService.updateItem(cookbook);
            model.setCookbook((Cookbook) itemService.getItem(cookbook.getId()));
        } catch (Exception ignored) {

        }
    }
}
