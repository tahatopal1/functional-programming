package com.project.functional.u8_functionalprogrammingindepth.s42_purefunctions;

public class Demo {
    public static void main(String[] args) {

        // Two conditions to make it a Pure Function

        // 1) Deterministic output: Always returns the same output,
        // ... with the given same inputs and solely depends on its
        // ... input parameters.

        // 2) No side effects: Causes no side effects like modifying
        // ... external state, global variables, input params, IO ops
        // ... or calling other functions with side effects

        int result = add(multiply(2,3), multiply(3, 4));
        System.out.println("Result: " + result);

        // Result will change, this time there will be some logging
        // So, multiply method is not a Pure Function
        result = add(6, 12);
        System.out.println("Result: " + result);


    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        log(String.format("Returning %s as the result of %s * %s", a * b, a, b));
        return a * b;
    }

    public static void log(String m) {
        System.out.println(m);
    }

}
