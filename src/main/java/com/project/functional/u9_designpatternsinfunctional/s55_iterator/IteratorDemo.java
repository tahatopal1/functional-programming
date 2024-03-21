package com.project.functional.u9_designpatternsinfunctional.s55_iterator;

public class IteratorDemo {

    // Accessing elements of a collection without exposing the internal structure

    public static void main(String[] args) {

        MyArraylist list = new MyArraylist(new Object[]{1,2,3,4,5,6});
        list.forEach(System.out::println);

    }
}
