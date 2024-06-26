package org.example.data.models;

public class ColoringBook extends Item implements Cloneable {
    private final String theme;
    private final int numberOfDrawings;
    private int numberOfDrawingsCompleted;


    public ColoringBook(int id, int price, String theme, int numberOfDrawings, int numberOfDrawingsCompleted) {
        super(id, price);
        this.theme = theme;
        this.numberOfDrawings = numberOfDrawings;
        this.numberOfDrawingsCompleted = numberOfDrawingsCompleted;
    }

    public ColoringBook(ColoringBook obj) {
        super(obj);
        this.theme = obj.theme;
        this.numberOfDrawings = obj.numberOfDrawings;
        this.numberOfDrawingsCompleted = obj.numberOfDrawingsCompleted;
    }

    public void draw() throws Exception {
        if(numberOfDrawingsCompleted >= numberOfDrawings) {
            throw new Exception("You have drawn all the drawings in this drawing book");
        }
        numberOfDrawingsCompleted += 1;
    }

    @Override
    public ColoringBook clone() {
        return new ColoringBook(this);
    }

    @Override
    public String description() {
        return "Coloring book - " + theme;
    }

    public int getNumberOfDrawings() {
        return numberOfDrawings;
    }

    public int getNumberOfDrawingsCompleted() {
        return numberOfDrawingsCompleted;
    }

    public String getTheme() {
        return theme;
    }
}
