package com.project.functional.u9_designpatternsinfunctional.s55_iterator;

import java.util.function.Consumer;

public class MyArraylist {

    Object[] elements = new Object[5];

    public MyArraylist(Object[] elements) {
        this.elements = elements;
    }

    public void forEach(Consumer<Object> action) {
        for (int i = 0; i < elements.length; i++) {
            action.accept(elements[i]);
        }
    }

}
