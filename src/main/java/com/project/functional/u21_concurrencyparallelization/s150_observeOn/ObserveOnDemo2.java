package com.project.functional.u21_concurrencyparallelization.s150_observeOn;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ObserveOnDemo2 {
    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Sushi")
                .subscribeOn(Schedulers.computation()) // This one will be processed
                .map(String::toUpperCase)
                .doOnNext(e -> System.out.println(Thread.currentThread().getName() + " : " + e))
                .observeOn(Schedulers.newThread()) // This one will be processed this time
                .filter(str -> str.startsWith("P"))
                .observeOn(Schedulers.io())
                .subscribe(ObserveOnDemo2::print);

        Thread.sleep(15000);

    }

    public static void print(String str) throws InterruptedException {
        System.out.println(str + ": Printed By: " + Thread.currentThread().getName());
    }
}
