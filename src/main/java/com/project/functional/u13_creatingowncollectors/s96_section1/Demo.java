package com.project.functional.u13_creatingowncollectors.s96_section1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

public class Demo {

    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 96, 18, 23);
        Collector<Integer, List<Integer>, List<Integer>> toList = Collector.of(
                ArrayList::new,     // Supplier
                List::add,          // BiConsumer
                (list1, list2) -> { // BiFunction
                    list1.addAll(list2);
                    return list1;
                },
                Collector.Characteristics.IDENTITY_FINISH
        );

        List<Integer> evens = numbers.stream()
                .filter(e -> e % 2 == 0)
                .collect(toList);

        evens.forEach(System.out::println);
    }

}
