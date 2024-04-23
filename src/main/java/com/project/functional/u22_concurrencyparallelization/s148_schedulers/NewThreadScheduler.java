package com.project.functional.u22_concurrencyparallelization.s148_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;

public class NewThreadScheduler {

    // It creates a new thread for every subscriber.
    // Different than I/O scheduler in killing the threads after
    // ... completing the job.


    public static void main(String[] args) throws InterruptedException {
        Observable<String> src = Observable.fromIterable(
                        Arrays.asList("Pasta", "Pizza", "Fries", "Curry",
                                "Chow Mein", "Kebab", "Gnocchi", "Hamburger",
                                "Sushi", "Taco", "Fish&Chips", "Burrito"))
                .subscribeOn(Schedulers.newThread());

        // You'll never see the Thread-1 again since it kills it and never uses
        src.subscribe(e -> compute());
        Thread.sleep(15000);

        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());
        src.subscribe(e -> compute());

        Thread.sleep(30000);
    }

    private static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }
}
