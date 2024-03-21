package com.project.functional.u6_methodandconstructorreference.s28_methodreference;

import java.util.function.BiFunction;

public class StaticMethodReference {
    public static void main(String[] args) {
        // Method reference as BiFunction
        BiFunction<String, String, String> biFunction = A_Class::staticMethod;
        System.out.println(biFunction.apply("Productivity", "Durability"));
    }
}

class A_Class {
    static String staticMethod(String a, String b) {
        return a + "and" + b;
    }
}
