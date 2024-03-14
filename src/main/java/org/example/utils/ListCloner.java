package org.example.utils;

import java.util.ArrayList;

public class ListCloner {

    private ListCloner() {}

    public static <> ArrayList<T> clone(ArrayList<T> list) {
        ArrayList<T> copy = new ArrayList<>();
        for(T value: list) {
            copy.add(new T(value));
        }
    }
}
