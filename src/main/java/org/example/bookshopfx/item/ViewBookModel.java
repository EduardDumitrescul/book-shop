package org.example.bookshopfx.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.data.models.Book;

public class ViewBookModel {
    private Book book;

    private StringProperty title = new SimpleStringProperty();
    private StringProperty author = new SimpleStringProperty();
    private StringProperty totalPages = new SimpleStringProperty();
    private StringProperty currentPage = new SimpleStringProperty();

    public void setBook(Book book) {
        this.book = book;
        title.set(book.getTitle());
        author.set(book.getAuthor());
        totalPages.set(String.valueOf(book.getNumberOfPages()));
        currentPage.set(String.valueOf(book.getNumberOfPagesRead()));
    }

    public Book getBook() {
        return book;
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty authorProperty() {
        return author;
    }

    public StringProperty totalPagesProperty() {
        return totalPages;
    }

    public StringProperty currentPageProperty() {
        return currentPage;
    }
}
