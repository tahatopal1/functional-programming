package com.project.functional.u21_concurrencyparallelization.s148_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;

public class IOScheduler {

    // Optimized for I/O-bound tasks. Unlike the computation scheduler,
    // ... the I/O scheduler can expand the number of threads beyond
    // ... the CPU limit because it assumes that most of the thread's
    // ... time is spent waiting for I/O operations (like network requests
    // ... or disk operations)

    // In Macbook Pro, 11 cores available. You'll catch a thread
    // ... with number "12"
    public static void main(String[] args) throws InterruptedException {

        Observable<String> src = Observable.fromIterable(
                Arrays.asList("Pasta", "Pizza", "Fries", "Curry",
                        "Chow Mein", "Kebab", "Gnocchi", "Hamburger",
                        "Sushi", "Taco", "Fish&Chips", "Burrito"))
                .subscribeOn(Schedulers.io());

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
