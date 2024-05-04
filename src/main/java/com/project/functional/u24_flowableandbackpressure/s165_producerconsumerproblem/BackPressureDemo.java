package com.project.functional.u24_flowableandbackpressure.s165_producerconsumerproblem;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BackPressureDemo {

    // In this example, emissions are being produced much faster
    // ... than the observer can process and the backlogged emissions
    // ... get queued up by observeOn in an unbounded manner.
    //  This could lead to many problems such as out of memory error.

    public static void main(String[] args) {
        Observable.range(1, 1000000)
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
