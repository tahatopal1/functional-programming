package com.project.functional.u21_concurrencyparallelization.s148_schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;

public class ComputationScheduler {

    // Optimized for CPU-intensive work that doesn't involve I/O
    // It uses a fixed number of threads equal to number of available
    // ... CPU cores.

    // In Macbook Pro, 11 cores available. You'll never catch a thread
    // ... with number "12"
    public static void main(String[] args) throws InterruptedException {

        Observable<String> src = Observable.fromIterable(
                        Arrays.asList("Pasta", "Pizza", "Fries", "Curry",
                                "Chow Mein", "Kebab", "Gnocchi", "Hamburger",
                                "Sushi", "Taco", "Fish&Chips", "Burrito"))
                .subscribeOn(Schedulers.computation());

        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));
        src.subscribe(e -> compute(e));

        Thread.sleep(14000);
    }

    private static void compute(String str) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(str + " computation done by: " + Thread.currentThread().getName());
    }
}
