package com.project.functional.u5_predefinedfunctionalinterfaces.s19_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatePractice {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Productivity");
        list.add("");
        list.add("Durability");
        list.add("");

        // Filtering the non-empty Strings out of an arraylist
        Predicate<String> predicate = s -> !s.isBlank();
        List<String> newList = filterList(list, predicate);
        System.out.println(newList);

        // Filtering the strings contain "ty"
        Predicate<String> predicate1 = s -> s.contains("ty");
        newList = filterList(list, predicate1);
        System.out.println(newList);

        // Filtering the even numbers
        List<Integer> intList = List.of(1, 4, 6, 7, 8);
        Predicate<Integer> integerFilter = i -> i % 2 == 0;
        List<Integer> evenList = filterList(intList, integerFilter);
        System.out.println(evenList);

    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T item: list) {
            if (predicate.test(item)) {
                newList.add(item);
            }
        }
        return newList;
    }
}
