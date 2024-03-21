package com.project.functional.u10_streamsandparallelstreams.s75_infinitestreams;

import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        System.out.println("*** ITERATE ***");
        Stream.iterate(-5, i -> i + 1)
                .limit(10) // Intermediate function // If don't put here, it runs until getting StackOverflowException
                .forEach(System.out::println);

        System.out.println("*** GENERATE ***");
        Stream.generate(Math::random) // Takes a supplier
                .limit(10)
                .forEach(System.out::println);
    }
}
