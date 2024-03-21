package com.project.functional.u10_streamsandparallelstreams.s69_map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapDemo {

    // Map is a higher order function
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9)
                .map(e -> e * 100)
                .forEach(System.out::println);

        System.out.println("----------------------");

        // You cannot mutate the source while iterating
        try {
            List<Integer> integerList
                    = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
            integerList.stream()
                    .map(integerList::remove)
                    .toList();
        } catch (Exception e) {
            System.out.println("You cannot modify the source: " + e);
        }
    }

}
