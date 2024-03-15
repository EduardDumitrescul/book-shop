package org.example.data.entities;

import org.example.data.Cloneable;

public class InventoryEntity implements Cloneable {
    int id;

    public InventoryEntity(
            int id
    ) {
        this.id = id;
    }


    public InventoryEntity(InventoryEntity obj) {
        this.id = obj.id;
    }

    @Override
    public InventoryEntity clone() {
        return new InventoryEntity(this);
    }

    public int getId() {
        return id;
    }
}
