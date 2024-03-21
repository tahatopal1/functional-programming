package com.project.functional.u3_lambdaandfunctionalinterface.s8_imperativevsdeclarative;

import java.util.stream.IntStream;

public class ImperativeVsDeclarativeDemo {
    public static void main(String[] args) {

        // Declarative Programming is superset of Functional Programming
        // You can pass behaviours as a parameter in Declarative Programming
        // You tell what to do instead of how to do Declarative Programming (just like SQL)

        // Imperative way
        int sumOfEvens = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sumOfEvens = sumOfEvens + i;
            }
        }
        System.out.println("Sum of evens = " + sumOfEvens);

        // Declarative (or Functional) way
        sumOfEvens = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce((x, y) -> x + y)
                .getAsInt();
        System.out.println("Sum of evens = " + sumOfEvens);
        
        // Declarative or Functional style is more readable and concise
        // Also we are not mutating any states, all the mutation are managed underneath
        // JVM is smart enough to take care of data mutation under the sheet
        // So, declarative way is thread-safe, whereas imperative way is not
        //  (since it is mutating the sumOfEvents variablef)

    }
}
