package com.project.functional.u10_streamsandparallelstreams.s78_statelessandstatefuloperations;

import java.util.List;

public class Demo {

    public static void main(String[] args) {

        // Stateless operations: Do not need any kind of outside information
        // Stateful operations: Uses outside information

        // Stateless operations only interested in the item that's being processed.
        // For example map, filter, forEach

        // For stateful operations, information of other items matters.
        // For example distinct, sorted, limit

        // To make it distinct, it needs to know if that item any duplicate
        // ... within the sequence.

        // To sort it, every item should be visible.

        // To limit it, present size of the sequence is needed.

        // Also it's visible on JavaDoc if the method is Stateless or Stateful


        // This gives an inaccurate result
        List.of(2,55,1,-15, 86,3, 21, 16, -100)
                .parallelStream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("**********************");

        // This gives an accurate result
        List.of(2,55,1,-15, 86,3, 21, 16, -100)
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("**********************");

        List.of(0,1,2,3,4,5,6,7,8,9)
                .parallelStream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("**********************");


        Integer reduce = List.of(0, 1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, Integer::sum);
        System.out.println(reduce);

    }

}
