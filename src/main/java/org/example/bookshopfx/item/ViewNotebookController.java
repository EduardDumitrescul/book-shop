package org.example.bookshopfx.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.models.Notebook;
import org.example.services.ItemService;

import java.util.List;

public class ViewNotebookController {
    private ViewNotebookModel model = new ViewNotebookModel();
    private ItemService itemService = ItemService.getInstance();
    public Label type;
    public Label pages;
    public Label pagesWritten;

    @FXML
    private void initialize() {
        List<String> args = NavigationController.getInstance().getArguments();
        int itemId = Integer.parseInt(args.get(0));
        model.setNotebook((Notebook) itemService.getItem(itemId));

        type.textProperty().bind(model.typeProperty());
        pages.textProperty().bind(model.pagesProperty());
        pagesWritten.textProperty().bind(model.pagesWrittenProperty());
    }

    public void back(ActionEvent actionEvent) {
        NavigationController.getInstance().navigateBack();
    }

    public void write(ActionEvent actionEvent) {
        try {
            Notebook notebook = model.getNotebook();
            notebook.write();
            itemService.updateItem(notebook);
            model.setNotebook((Notebook) itemService.getItem(notebook.getId()));
        } catch (Exception ignored) {

        }

    }
}
