package com.project.functional.u14_collectionfunctional.s102_map;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        HashMap<String, String> contacts = new HashMap<>();
        contacts.put("1234567890", "John");
        contacts.put("2534467290", "John");
        contacts.put("6224587995", "Neal");
        contacts.put("5232577843", "Raju");
        contacts.put("4263126677", "Peter");
        contacts.put("9962312512", "Neha");

        // Traversal
        // Imperative way
        System.out.println("***** TRAVERSAL *****");

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("------------------");

        // Declarative way
        contacts.forEach((key, value) -> System.out.println(key + " - " + value));

        System.out.println("------------------");

        // Filter
        System.out.println("***** FILTER *****");

        contacts.entrySet().stream()
                .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

        System.out.println("------------------");

        // Collect
        System.out.println("***** COLLECT *****");

        Map<String, String> collect = contacts.entrySet().stream()
                .filter(contact -> "John".equalsIgnoreCase(contact.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect);
        System.out.println("------------------");


        // Map
        System.out.println("***** MAP *****");

        String names = contacts.entrySet().stream()
                .distinct()
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(", "));
        System.out.println(names);
        System.out.println("------------------");

        // Sorting
        System.out.println("***** SORTING *****");

        LinkedHashMap<String, String> sortedMap = contacts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey
                        , Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
        System.out.println(sortedMap);

        TreeMap<String, String> treeMap = new TreeMap<>(contacts); // shortcut | sorts by key
        System.out.println(treeMap);
        System.out.println("------------------");

        // Reduce
        System.out.println("***** REDUCE *****");

        HashMap<String, Double> marks = new HashMap<>();
        marks.put("Science", 66.00);
        marks.put("Maths", 100.00);
        marks.put("English", 50.00);

        marks.values().stream()
                .mapToDouble(d -> d)
                .average()
                .ifPresent(System.out::println);


    }
}
