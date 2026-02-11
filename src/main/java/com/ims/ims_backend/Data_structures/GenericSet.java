package com.ims.ims_backend.Data_structures;

import java.util.HashSet;
import java.util.Set;

public class GenericSet<T> {
    private Set<T> items = new HashSet<>();

    public void add(T item){
        items.add(item);
    }
    public void get(int index){
        items.iterator();
    }
}
