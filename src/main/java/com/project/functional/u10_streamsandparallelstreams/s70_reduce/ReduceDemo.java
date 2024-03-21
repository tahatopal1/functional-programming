package com.project.functional.u10_streamsandparallelstreams.s70_reduce;

import java.util.stream.Stream;

public class ReduceDemo {
    public static void main(String[] args) {
        Integer sum = Stream.of(1, 2, 34, 56, 76, 87, 89)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
