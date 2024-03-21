package com.project.functional.u5_predefinedfunctionalinterfaces.s24_bifunction;

import java.util.function.BiFunction;

public class BiFunctionPractice {
    public static void main(String[] args) {

        // Concat and get the length
        BiFunction<String, String, Integer> biFunction = (a, b) -> (a + b).length();
        System.out.println(biFunction.apply("Productivity", "Durability"));
    }
}
