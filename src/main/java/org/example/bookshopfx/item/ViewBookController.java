package org.example.bookshopfx.item;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.bookshopfx.navigation.NavigationController;
import org.example.data.models.Book;
import org.example.services.ItemService;

import java.util.List;

public class ViewBookController {
    private ViewBookModel model;
    private ItemService itemService = ItemService.getInstance();

    @FXML
    private Label title;
    @FXML
    private Label author;
    @FXML
    private Label totalPages;
    @FXML
    private Label currentPage;

    public ViewBookController() {
        model = new ViewBookModel();

    }
    @FXML
    private void initialize() {
        List<String> args = NavigationController.getInstance().getArguments();
        model.setBook((Book) itemService.getItem(Integer.parseInt(args.get(0))));
        title.textProperty().bind(model.titleProperty());
        author.textProperty().bind(model.authorProperty());
        totalPages.textProperty().bind(model.totalPagesProperty());
        currentPage.textProperty().bind(model.currentPageProperty());
    }

    public void back(ActionEvent actionEvent) {
        navigateBack();
    }

    public void read(ActionEvent actionEvent) {
        try {
            Book book = model.getBook();
            book.read();
            itemService.updateItem(book);
            model.setBook((Book) itemService.getItem(book.getId()));
        } catch (Exception ignored) {
        }
    }

    private void navigateBack() {
        NavigationController.getInstance().navigateBack();
    }

    public void throwAway(ActionEvent actionEvent) {
        int itemId = model.getBook().getId();
        itemService.throwAwayItem(itemId);
        navigateBack();
    }
}
