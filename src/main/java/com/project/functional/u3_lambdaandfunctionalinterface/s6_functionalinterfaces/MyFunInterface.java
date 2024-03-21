package com.project.functional.u3_lambdaandfunctionalinterface.s6_functionalinterfaces;

// This is functional interface
// If you try to make it have more than one abstract method, it gets error in compile time
// You don't have to use the @FunctionalInterface annotation if you have only one abstract method
// It's usually used for making sure that it is a functional interface
@FunctionalInterface
public interface MyFunInterface {
    void myMethod();
}
