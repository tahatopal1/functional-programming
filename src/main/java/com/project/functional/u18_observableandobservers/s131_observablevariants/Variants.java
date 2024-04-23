package com.project.functional.u18_observableandobservers.s131_observablevariants;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class Variants {
    public static void main(String[] args) {

        Observable<String> source = Observable.just("Alex", "Justin", "Jack");
        Observable<String> empty = Observable.empty();

        // Single: Emission of only one item
        System.out.println("----- SINGLE -----");
        source.first("Name").subscribe(System.out::println); // Will print "Alex"
        empty.first("Name").subscribe(System.out::println); // Will print "Name" as it's empty
        Single.just("Alex").subscribe(System.out::println); // Creating single on the fly

        // Maybe: Emission of 0 or 1 item
        System.out.println("----- MAYBE -----");

        // Ony print the onComplete() method as it's empty
        empty.firstElement().subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        // Completable: No emissions
        System.out.println("----- COMPLETABLE -----");
        Completable
                .fromRunnable(() -> System.out.println("Some process executing"))
                .subscribe(() -> System.out.println("The process executed successfully"));

    }
}
