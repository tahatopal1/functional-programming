package com.project.functional.u21_concurrencyparallelization.s149_subscribeOn;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SubscribeOnDemo {
    public static void main(String[] args) throws InterruptedException {

        Observable.just("Pasta", "Pizza", "Fries", "Curry", "Sushi")
                .subscribeOn(Schedulers.computation()) // This one will be processed
                .map(String::toUpperCase)
                .subscribeOn(Schedulers.computation()) // This one won't be processed
                .filter(str -> str.startsWith("P"))
                .subscribe(SubscribeOnDemo::print);

        Thread.sleep(6000);

    }

    public static void print(String str) {
        System.out.println(str + ": Printed By: " + Thread.currentThread().getName());
    }

}
