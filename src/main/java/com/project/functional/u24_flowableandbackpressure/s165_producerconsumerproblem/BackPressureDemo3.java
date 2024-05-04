package com.project.functional.u24_flowableandbackpressure.s165_producerconsumerproblem;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackPressureDemo3 {

    // A bit less performant. But handled greatly.
    public static void main(String[] args) {
        Observable.range(1, 1000000)
                .subscribeOn(Schedulers.io())
                .map(e -> {
                    System.out.println("Producer item is: " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .subscribe(e -> {
                    sleep(100);
                    System.out.println("Consumed item is: " + e + " : " + Thread.currentThread().getName());
                });

        sleep(100000000);
    }


    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
