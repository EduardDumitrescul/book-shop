package org.example.data.entities;

import org.example.data.Cloneable;

public class BookEntity implements Cloneable {
    public int id;
    public String title;
    public String author;

    public int numberOfPages;
    public int numberOfPagesRead;

    public BookEntity(int id, String title, String author, int numberOfPages, int numberOfPagesRead) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.numberOfPagesRead = numberOfPagesRead;
    }

    public BookEntity(BookEntity obj) {
        this.id = obj.id;
        this.title = obj.title;
        this.author = obj.author;
        this.numberOfPages = obj.numberOfPages;
        this.numberOfPagesRead = obj.numberOfPagesRead;
    }

    @Override
    public BookEntity clone() {
        return new BookEntity(this);
    }
}
