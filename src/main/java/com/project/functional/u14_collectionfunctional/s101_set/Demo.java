package com.project.functional.u14_collectionfunctional.s101_set;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(3, 56, 7, 82, 39);

        // Traversal
        numbers.forEach(System.out::println);
        System.out.println("--------------");

        // Filter
        numbers.stream()
                .filter(e -> e % 2 == 0)
                .forEach(System.out::println);
        System.out.println("--------------");

        // Sorting
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("--------------");

//        TreeSet<Integer> treeSet = new TreeSet<>(numbers);
//
//        TreeSet<Integer> treeSet = numbers.stream()
//                .collect(Collectors.toCollection(TreeSet::new));

        // Map
        Set<Double> hashSet = numbers.stream()
                .map(Double::valueOf)
                .collect(Collectors.toSet());
        hashSet.forEach(System.out::println);
        System.out.println("--------------");

        // Reduce
        int sum = numbers.stream()
                .mapToInt(val -> val)
                .sum();
        System.out.println(sum);

    }
}
