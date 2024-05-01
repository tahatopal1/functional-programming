package com.project.functional.u21_concurrencyparallelization.s148_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;

public class SingleScheduler {

    // Guarantees that all tasks are scheduled on the same thread.
    // This is useful for operations that need to be executed in order
    // ... but do not require running on the main thread. It's also used
    // ... to avoid concurrency issues without using locks or synchronization
    // However, it decreases the throughput in return.

    public static void main(String[] args) throws InterruptedException {

        Observable<String> src = Observable.fromIterable(
                        Arrays.asList("Pasta", "Pizza", "Fries", "Curry",
                                "Chow Mein", "Kebab", "Gnocchi", "Hamburger",
                                "Sushi", "Taco", "Fish&Chips", "Burrito"))
                .subscribeOn(Schedulers.single());

        // You'll see only the Thread-1
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
        src.subscribe(e -> compute());

        Thread.sleep(14000);
    }

    private static void compute() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Computation done by: " + Thread.currentThread().getName());
    }


}
