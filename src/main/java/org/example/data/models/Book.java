package org.example.data.models;

public class Book extends Item implements Cloneable {
    private String title;
    private String author;
    private int numberOfPages;
    private int numberOfPagesRead;


    public Book(int id, int price, String title, String author, int numberOfPages, int numberOfPagesRead) {
        super(id, price);
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.numberOfPagesRead = numberOfPagesRead;
    }

    public Book(Book obj) {
        super(obj);
        this.title = obj.title;
        this.author = obj.author;
        this.numberOfPages = obj.numberOfPages;
        this.numberOfPagesRead = obj.numberOfPagesRead;
    }

    public void read() throws Exception {
        if(numberOfPagesRead >= numberOfPages) {
            throw new Exception("You've already read this book");
        }
        numberOfPagesRead ++;
    }

    @Override
    public Book clone() {
        return new Book(this);
    }

    @Override
    public String description() {
        return "Book - " + title + ", " + author;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getNumberOfPagesRead() {
        return numberOfPagesRead;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
