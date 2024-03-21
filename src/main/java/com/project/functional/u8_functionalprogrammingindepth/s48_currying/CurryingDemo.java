package com.project.functional.u8_functionalprogrammingindepth.s48_currying;

import java.util.function.Function;

public class CurryingDemo {

    // Currying means restructuring a multi-parameter function
    // ... into multiple functions that takes single parameter

    public static void main(String[] args) {

        Function<Integer, Function<Integer, Integer>> currying =  u -> v -> u + v;

        Function<Integer, Integer> addBy10 = currying.apply(10);
        Integer result = addBy10.apply(5);

        System.out.println("Result: " + result);

        // or direct call
        Integer result2 = currying.apply(20).apply(5);
        System.out.println("Result 2: " + result2);

    }
}
