package com.project.functional.u3_lambdaandfunctionalinterface.s6_functionalinterfaces;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {

        // We can store functions into variables
        MyFunInterface fun = () -> System.out.println("Hello");
        fun.myMethod();

        // We can pass functions as parameters
        onTheFly(() -> System.out.println("Hi"));

    }

    public static void onTheFly(MyFunInterface fun) {
        fun.myMethod();
    }
}
