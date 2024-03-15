package org.example.data.models;

import org.example.data.Cloneable;

public class DrawingBook extends Item implements Cloneable {
    private String theme;
    private int numberOfDrawings;
    private int numberOfDrawingsCompleted;


    public DrawingBook(int id, int price, String theme, int numberOfDrawings, int numberOfDrawingsCompleted) {
        super(id, price);
        this.theme = theme;
        this.numberOfDrawings = numberOfDrawings;
        this.numberOfDrawingsCompleted = numberOfDrawingsCompleted;
    }

    public DrawingBook(DrawingBook obj) {
        super(obj);
        this.theme = obj.theme;
        this.numberOfDrawings = obj.numberOfDrawings;
        this.numberOfDrawingsCompleted = obj.numberOfDrawingsCompleted;
    }

    void draw() throws Exception {
        if(numberOfDrawingsCompleted >= numberOfDrawings) {
            throw new Exception("You have drawn all the drawings in this drawing book");
        }
        numberOfDrawingsCompleted += 1;
    }

    @Override
    public DrawingBook clone() {
        return new DrawingBook(this);
    }
}
