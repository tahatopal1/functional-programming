package com.project.functional.u6_methodandconstructorreference.s28_methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    public static void main(String[] args) {
        List<Integer> list = List.of(34, 67, 8, 91, 22);

        // Method reference as Consumer
        // System.out is returns an object, then print method comes as a reference
        // Object instance method
        Consumer<Integer> consumer = System.out::println;
        consumer.accept(56);

        printElements(list, consumer);

        // Method reference as Supplier
        // random() is a static method
        // Class static method
        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());

        // Method reference as Function
        // Takes no parameter, uses the classes instance instead
        // Class instance method
        List<String> strList = List.of("Kit", "Kat", "Shake");
        Function<String, Integer> lenFun = String::length;

        List<Integer> map = map(strList, lenFun);
        System.out.println(map);
    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer) {
        for (T t: list) {
            consumer.accept(t);
        }
    }

    private static <T, R> List<R> map (List<T> list, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T t : list) {
            R applied = function.apply(t);
            newList.add(applied);
        }
        return newList;
    }

}
