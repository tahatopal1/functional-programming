package com.project.functional.u21_concurrencyparallelization.s151_concurrencywithflatmap;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;

public class ConcurrencyWithFlatMap {
    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Sushi")
                .flatMap(e -> Observable.just(e)
                        .subscribeOn(Schedulers.computation())
                        .map(ConcurrencyWithFlatMap::compute))
                .subscribeOn(Schedulers.computation())
                .subscribe(System.out::println);

        Thread.sleep(7000);

    }

    public static String compute(String element) {
        return element + "Printed By: " + Thread.currentThread().getName() + " at: " + LocalTime.now();
    }

}
