package com.project.functional.u3_lambdaandfunctionalinterface.s7_howlambdaworks;

import com.project.functional.u3_lambdaandfunctionalinterface.s6_functionalinterfaces.MyFunInterface;

public class LambdaUnderTheHood {
    public static void main(String[] args) {
        MyFunInterface fun1 = new MyFunInterface() {
            @Override
            public void myMethod() {
                System.out.println("Implementation 1");
            }
        };

        MyFunInterface fun2 = new MyFunInterface() {
            @Override
            public void myMethod() {
                System.out.println("Implementation 2");
            }
        };

        // In the way above, there will be 2 different .class files generated
        // If we use anonymous inner classes, our app will be bulky

        // If we use lambda expressions instead, there will be no .class file
        // generated for the inner classes

        // Lambda expressions make use of type inference and dynamic calling.
        // It ensures that Java utilize the dynamic language mechanisms. Also
        // optimizes the memory

        MyFunInterface lambda = () -> System.out.println("Lambda implementation");

    }
}
