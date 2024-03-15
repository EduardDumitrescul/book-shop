package org.example.data.entities;

import org.example.data.Cloneable;

public class ColoringBook extends BaseEntity implements Cloneable {
    public String theme;
    public int numberOfDrawings;
    public int numberOfDrawingCompleted;

    public ColoringBook(int id, String theme, int numberOfDrawings, int numberOfDrawingCompleted) {
        super(id);
        this.theme = theme;
        this.numberOfDrawings = numberOfDrawings;
        this.numberOfDrawingCompleted = numberOfDrawingCompleted;
    }

    public ColoringBook(ColoringBook obj) {
        super(obj.id);
        this.theme = obj.theme;
        this.numberOfDrawings = obj.numberOfDrawings;
        this.numberOfDrawingCompleted = obj.numberOfDrawingCompleted;
    }

    @Override
    public ColoringBook clone() {
        return new ColoringBook(this);
    }
}
