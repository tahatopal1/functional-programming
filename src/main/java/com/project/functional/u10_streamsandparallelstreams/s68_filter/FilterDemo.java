package com.project.functional.u10_streamsandparallelstreams.s68_filter;

import java.util.stream.Stream;

public class FilterDemo {

    // Filter is a higher order function
    public static void main(String[] args) {
        Stream.of(34, 678, 89, 4, 52, 31, 325, 6)
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
    }
}
