package com.project.functional.u19_rxoperators.s136_typesofoperators;

import io.reactivex.rxjava3.core.Observable;

public class ReducingOperators {
    public static void main(String[] args) {

        Observable<String>  fruits = Observable.just("Apple", "Banana", "Chery", "Date");
        Observable<Integer> numbers = Observable.just(1, 2, 3, 4, 5);

        // Count
        System.out.println("***** COUNT *****");
        fruits.count().subscribe(count -> System.out.println("Total Items: " + count));

        // Reduce
        System.out.println("***** REDUCE *****");
        numbers.reduce(0, (sum, item) -> sum + item)
                .subscribe(sum -> System.out.println("Sum: " + sum));

        // Contains
        System.out.println("***** CONTAINS *****");
        fruits.contains("Banana").subscribe(contains -> System.out.println("Contains Banana: " + contains));

        // All
        System.out.println("***** ALL *****");
        numbers.all(num -> num < 10).subscribe(result ->
                System.out.println("All numbers less than 10: " + result));

        // Any
        System.out.println("***** ANY *****");
        numbers.any(num -> num > 3).subscribe(result ->
                System.out.println("There's some numbers greater that 3: " + result));

    }
}
