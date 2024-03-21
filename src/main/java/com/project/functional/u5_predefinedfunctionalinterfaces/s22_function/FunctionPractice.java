package com.project.functional.u5_predefinedfunctionalinterfaces.s22_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionPractice {
    public static void main(String[] args) {
        List<String> stringList = List.of("Productivity", "Durability", "Conciseness");

        // Getting list of lengths by Function
        Function<String, Integer> function = e -> e.length();

        List<Integer> mappedList = map(stringList, function);
        System.out.println(mappedList);

    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T t: list) {
            R applied = function.apply(t);
            newList.add(applied);
        }
        return newList;
    }

}
