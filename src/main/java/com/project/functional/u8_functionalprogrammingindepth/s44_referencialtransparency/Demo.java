package com.project.functional.u8_functionalprogrammingindepth.s44_referencialtransparency;

public class Demo {

    // Referential transparency means a function,
    // ... can be replaced by its evaluated value
    // ... without affecting the behaviour of program.

    public static void main(String[] args) {

        // Scenario 1
        System.out.println("Scenario 1");
        int result = add(2, multiply(2, 4));
        int result2 = add(2, multiply(2, multiply(2, 2)));
        int result3 = add(2, 8);

        System.out.println("Result: " + result);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
        // result == result2 == result3
        // The result is the same even though you change
        // the function expression with the calculated outcome
        // multiply() method is referentially transparent


        // Scenario 2
        System.out.println("Scenario 2");
        result = add(2, multiplyWithLog(2, 4));
        result2 = add(2, multiplyWithLog(2, multiplyWithLog(2, 2)));
        result3 = add(2, 8);

        System.out.println("Result: " + result);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);


        // result == result2 == result3
        // But this time, we'll come across different log messages
        // multiplyWithLog() method isn't referentially transparent
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiplyWithLog(int a, int b) {
        System.out.printf("Multiplying %d and %d \n", a, b);
        return a * b;
    }

}
