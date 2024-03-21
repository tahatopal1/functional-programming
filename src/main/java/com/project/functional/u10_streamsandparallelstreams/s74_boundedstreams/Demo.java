package com.project.functional.u10_streamsandparallelstreams.s74_boundedstreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        // 1. Stream on a Collection
        List<Integer> list = List.of(1, 4, 7, 9, 4);
        Stream<Integer> integerStream = list.stream();

        // How to Stream a Map
        Map<Integer, String> map = Map.of(1, "one", 2, "two", 3, "three", 4, "four");
        Stream<Map.Entry<Integer, String>> entryStream = map.entrySet().stream();
        Stream<String> valuesStream = map.values().stream();
        Stream<Integer> keyStream = map.keySet().stream();

        // 2. of() method of Stream class
        Stream<String> stringStream = Stream.of("Hey!", "Happy!", "Good!");

        // 3. Stream of Arrays
        Integer[] integerArr = {3, 5, 7, 8, 9};
        Stream<Integer> referenceStream = Arrays.stream(integerArr); // Reference Stream

        int[] intArr = {3, 5, 7, 8, 9};
        IntStream primitiveStream = Arrays.stream(intArr); // Primitive Stream

        // 4. Builder pattern
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        builder.add(4);
        Stream<Integer> builtStream = builder.build();

    }
}
