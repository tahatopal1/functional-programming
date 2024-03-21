package com.project.functional.u13_creatingowncollectors.s97_section2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

public class Demo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 6, 8, 9, 0, 1, 52, 5, 61, 8, 9, 96, 0, 18, 23);
        Collector<Integer, List<Integer>, List<Integer>> sortedListCollector = Collector.of(
                ArrayList::new,
                List::add,
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                },
                list -> {
                    Collections.sort(list);
                    return list;
                },
                Collector.Characteristics.UNORDERED // We make our own ordering on finisher method
        );
        List<Integer> collected = numbers.stream().collect(sortedListCollector);
        collected.forEach(System.out::println);
    }
}
