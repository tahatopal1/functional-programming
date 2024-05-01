package com.project.functional.u21_concurrencyparallelization.s150_observeOn;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOnDemo {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Sushi")
                .subscribeOn(Schedulers.io()) // Start the chain on the I/O scheduler
                .map(query -> {
                    // Perform some network request
                    System.out.println("Fetching on: " + Thread.currentThread().getName());
                    return "Result of " + query;
                })
                .observeOn(Schedulers.computation()) // Switch to a computation thread
                .map(result -> {
                    // Perform some CPU-intensive calculation
                    System.out.println("Processing on: " + Thread.currentThread().getName());
                    return "Processed " + result;
                })
                .observeOn(Schedulers.single()) // Switch back to the main thread (only simulating, not actually main)
                .subscribe(result -> {
                    // Perform on main thread
                    System.out.println("Displaying on: " + Thread.currentThread().getName());
                    System.out.println(result);
                });

        Thread.sleep(6000);
    }

    public static void print(String str) {
        System.out.println(str + ": Printed By: " + Thread.currentThread().getName());
    }

}
