package org.example.bookshopfx.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.example.data.models.Notebook;

public class ViewNotebookModel {
    private Notebook notebook;
    private final StringProperty type = new SimpleStringProperty();
    private final StringProperty pages = new SimpleStringProperty();
    private final StringProperty pagesWritten = new SimpleStringProperty();

    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
        type.set(notebook.getType());
        pages.set(String.valueOf(notebook.getNumberOfPages()));
        pagesWritten.set(String.valueOf(notebook.getNumberOfPagesWritten()));
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public StringProperty typeProperty() {
        return type;
    }

    public StringProperty pagesProperty() {
        return pages;
    }

    public StringProperty pagesWrittenProperty() {
        return pagesWritten;
    }
}
