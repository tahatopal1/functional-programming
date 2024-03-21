package com.project.functional.u8_functionalprogrammingindepth.s45_chaining;

import java.util.function.Function;

public class ChainingDemo {

    // Function chaining refers to the concept of chaining multiple
    // ... functions in a row by using the output of previous function
    // ... to call next one.

    // Chaining can greatly enhance readability and efficiency in code
    // ... by expressing complex operations in a clear and linear fashion.

    public static void main(String[] args) {

        IConsumer<String> c1 = System.out::println;
        IConsumer<String> c2 = System.out::println;

        IConsumer<String> c3 = s -> {
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("Hello"); // Prints two time, but not too much like chaining

        IConsumer<String> c4 = c1.thenAcceptNullable(c2); // This one works, but does not fail fast
        c4.accept("How are you?");

        try {
            IConsumer<String> c5 = c1.thenAccept(null); // This one will fail
        } catch (Exception e) {
            System.out.println("Failed fast!");
        }

        // Chaining with Function
        Function<Integer, Integer> f1 = integer ->  integer + 2;
        Function<Integer, Integer> f2 = integer ->  integer * 2;
        Function<Integer, Integer> f3 = f1.andThen(f2);
        Integer applied = f3.apply(10);
        System.out.println("Applied result: " + applied);

    }

}
