package com.project.functional.u10_streamsandparallelstreams.s73_numericstreamsmethods;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Demo {
    public static void main(String[] args) {

        // IntStream
        // DoubleStream
        // LongStream

        // Sum: primitive
        System.out.println("*** SUM ***");
        int sum = IntStream.of(1, 2, 3).sum();
        System.out.println(sum); // 6

        sum = IntStream.of().sum();
        System.out.println(sum); // 0

        // Max: Optional primitive
        System.out.println("*** MAX ***");
        IntStream maxStream = IntStream.of(10, 20, 30);
        OptionalInt maxOpt = maxStream.max();
        System.out.println(maxOpt.getAsInt());

        OptionalInt max = IntStream.of().max();
        System.out.println(max.orElseGet(() -> {
            System.out.println("Fallback for max() method");
            return 0;
        }));

        // Min: Optional primitive
        System.out.println("*** MIN ***");
        IntStream minStream = IntStream.of(-10, -20, -30);
        OptionalInt minOpt = minStream.min();
        System.out.println(minOpt.getAsInt());

        // Average: Optional double primitive
        System.out.println("*** AVG ***");
        OptionalDouble avgOpt = IntStream.of(1, 2, 3, 4).average();
        System.out.println(avgOpt.getAsDouble());

        // Summary Statistics
        System.out.println("*** STATS ***");
        IntSummaryStatistics sumStats = IntStream.of(1, 2, 3, 4, 5, 6).summaryStatistics();
        System.out.println(sumStats);

    }
}
