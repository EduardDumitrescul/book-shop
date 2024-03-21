package org.example.bookshopfx.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.data.models.ColoringBook;

public class ViewColoringBookModel {

    private ColoringBook coloringBook;
    private StringProperty theme = new SimpleStringProperty();
    private StringProperty totalDrawings = new SimpleStringProperty();
    private StringProperty drawingsCompleted = new SimpleStringProperty();

    public void setColoringBook(ColoringBook coloringBook) {
        this.coloringBook = coloringBook;
        theme.set(coloringBook.getTheme());
        totalDrawings.set(String.valueOf(coloringBook.getNumberOfDrawings()));
        drawingsCompleted.set(String.valueOf(coloringBook.getNumberOfDrawingsCompleted()));
    }

    public ColoringBook getColoringBook() {
        return coloringBook;
    }

    public StringProperty themeProperty() {
        return theme;
    }

    public StringProperty totalDrawingsProperty() {
        return totalDrawings;
    }

    public StringProperty drawingsCompletedProperty() {
        return drawingsCompleted;
    }
}
