package org.example.data;

import java.util.ArrayList;
import java.util.List;

public interface Cloneable {
    Cloneable clone();

    default List<Cloneable> cloneList(ArrayList<Cloneable> list) {
        List<Cloneable> copy = new ArrayList<>();
        for(Cloneable value: list) {
            copy.add(value.clone());
        }
        return copy;
    }
}
