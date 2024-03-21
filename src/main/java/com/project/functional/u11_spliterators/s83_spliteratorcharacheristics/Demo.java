package com.project.functional.u11_spliterators.s83_spliteratorcharacheristics;

import java.util.*;
import java.util.stream.Stream;

public class Demo {

    // Spliterator is an interface in Java that serves the core
    // ... purpose of enabling parallel processing of collections
    // ... by offering mechanisms for iterating and partitioning
    // ... elements into smaller data sets for efficient processing.

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(7);
        list.add(9);
        list.add(0);
        list.add(1);

        Stream<Integer> stream = list.stream();
        Spliterator<Integer> spliterator = stream.spliterator();
        int bits = spliterator.characteristics();
        System.out.println(Integer.bitCount(bits));

        // List preserves the insertion order, returns true
        System.out.println(spliterator.hasCharacteristics(Spliterator.ORDERED));

        // List is not sorted by its nature, returns false
        System.out.println(spliterator.hasCharacteristics(Spliterator.SORTED));


        // About the code below,
        // Streams are working with Spliterators under the hood. So the
        // ...characteristics will be known to Stream and sorting operation
        // will be omitted because SortedSet is already a sorted collection by its nature.
        SortedSet<Integer> set = new TreeSet<>(list);
        set.stream()
                .sorted()
                .forEach(System.out::println);




    }
}
