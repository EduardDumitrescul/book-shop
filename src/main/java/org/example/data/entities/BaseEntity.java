package org.example.data.entities;

import org.example.data.Cloneable;

public abstract class BaseEntity implements Cloneable {

    public int id;

    public BaseEntity(int id) {
        this.id = id;
    }

    public BaseEntity(BaseEntity obj) {
        this.id = obj.id;
    }
    @Override
    public abstract BaseEntity clone();
}
