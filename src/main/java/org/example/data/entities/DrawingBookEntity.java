package org.example.data.entities;

import org.example.data.Cloneable;

public class DrawingBookEntity extends BaseEntity implements Cloneable {
    public String theme;
    public int numberOfDrawings;
    public int numberOfDrawingCompleted;

    public DrawingBookEntity(int id, String theme, int numberOfDrawings, int numberOfDrawingCompleted) {
        super(id);
        this.theme = theme;
        this.numberOfDrawings = numberOfDrawings;
        this.numberOfDrawingCompleted = numberOfDrawingCompleted;
    }

    public DrawingBookEntity(DrawingBookEntity obj) {
        super(obj.id);
        this.theme = obj.theme;
        this.numberOfDrawings = obj.numberOfDrawings;
        this.numberOfDrawingCompleted = obj.numberOfDrawingCompleted;
    }

    @Override
    public DrawingBookEntity clone() {
        return new DrawingBookEntity(this);
    }
}
