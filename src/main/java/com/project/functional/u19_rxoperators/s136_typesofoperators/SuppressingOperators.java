package com.project.functional.u19_rxoperators.s136_typesofoperators;

import io.reactivex.rxjava3.core.Observable;

public class SuppressingOperators {
    public static void main(String[] args) {

        Observable<Integer> observable1 = Observable.just(1, 2, 3, 4, 5);
        Observable<Integer> observable2 = Observable.just(1, 2, 2, 3, 3, 4, 4, 5);

        // Filter
        System.out.println("***** FILTER *****");
        observable1.filter(i -> i % 2 == 0)
                .subscribe(System.out::println); // Output: 2, 4

        // Take
        System.out.println("***** TAKE *****");
        observable1.take(3).subscribe(System.out::println); // Output: 1, 2, 3

        // Skip
        System.out.println("***** SKIP *****");
        observable1.skip(2).subscribe(System.out::println); // Output: 3, 4, 5

        // Distinct
        System.out.println("***** DISTINCT *****");
        observable2.distinct().subscribe(System.out::println); // Output: 1, 2, 3, 4, 5

        // Element At
        System.out.println("***** ELEMENT AT *****");
        observable1.elementAt(2)
                .subscribe(System.out::println
                        , Throwable::printStackTrace
                        , () -> System.out.println("Completed!")); // Output: 3

    }
}
