package com.project.functional.u9_designpatternsinfunctional.s59_factorymethod;

public class FactoryMethodDemo {

    // Creational pattern
    // Creating object without exposing instantiation logic

    // The factory design pattern is a way to instantiating
    // ... a class inside a designated method that we call factory method

    // Factory is an object that is able to create other objects

    public static void main(String[] args) {

        // We don't know which implementation we'll get
        Flooring flooring_1 = FlooringFactory.getFlooring(-1, 18);
        flooring_1.installation();
        Flooring flooring_2 = FlooringFactory.getFlooring(13, 48);
        flooring_2.installation();
    }
}
