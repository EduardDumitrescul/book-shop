package org.example.bookshopfx.home;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.data.models.User;

public class HomeModel {
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty numberOfBooks = new SimpleStringProperty();
    private final StringProperty numberOfColoringBooks = new SimpleStringProperty();
    private final StringProperty numberOfNotebooks = new SimpleStringProperty();
    private final StringProperty numberOfCookbooks = new SimpleStringProperty();
    private User user;

    public void setUser(User user) {
        this.user = user;
        username.set(user.getUsername());
        numberOfBooks.set(user.getInventory().getNumberOfBooks() + " books");
        numberOfCookbooks.set(user.getInventory().getNumberOfCookbooks() + " cookbooks");
        numberOfNotebooks.set(user.getInventory().getNumberOfNotebooks() + " notebooks");
        numberOfColoringBooks.set(user.getInventory().getNumberOfColoringBooks() + " coloring books");
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public StringProperty numberOfBooksProperty() {
        return numberOfBooks;
    }

    public StringProperty numberOfColoringBooksProperty() {
        return numberOfColoringBooks;
    }

    public StringProperty numberOfCookbooksProperty() {
        return numberOfCookbooks;
    }

    public StringProperty numberOfNotebooksProperty() {
        return numberOfNotebooks;
    }

    public final void setUsername(String username) {
        usernameProperty().set(username);
    }
}
