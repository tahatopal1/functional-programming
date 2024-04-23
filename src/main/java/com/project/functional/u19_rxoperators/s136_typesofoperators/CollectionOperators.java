package com.project.functional.u19_rxoperators.s136_typesofoperators;

import io.reactivex.rxjava3.core.Observable;

import java.util.Comparator;
import java.util.HashSet;

public class CollectionOperators {
    public static void main(String[] args) {

        Observable<String> fruits = Observable.just("Apple", "Banana", "Cherry");

        // To List
        System.out.println("***** To List *****");
        fruits
                .toList()
                .subscribe(list
                        -> System.out.println("List: " + list)); // Output: [Apple, Banana, Cherry]


        // To Sorted List
        System.out.println("***** To Sorted List *****");
        Observable.just(3, 1, 4, 1, 5)
                .toSortedList()
                .subscribe(sortedList
                        -> System.out.println("Sorted List: " + sortedList)); // Output: [1, 1, 3, 4, 5]

        // With a custom Comparator
        System.out.println("***** To Sorted List Reversed *****");
        Observable.just(3, 1, 4, 1, 5)
                .toSortedList(Comparator.reverseOrder())
                .subscribe(sortedList
                        -> System.out.println("Reverse Sorted List: " + sortedList)); // Output: [5, 4, 3, 1, 1]

        // To Map
        System.out.println("***** To Map *****");
        fruits.toMap(item -> item.charAt(0)).subscribe(System.out::println);

        // Collect
        System.out.println("***** Collect *****");
        fruits.collect(HashSet::new, HashSet::add).subscribe(System.out::println);

        fruits.collect(StringBuilder::new, StringBuilder::append)
                .subscribe(System.out::println); // Output: AppleBananaCherry



    }
}
