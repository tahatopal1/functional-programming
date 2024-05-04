package com.project.functional.u24_flowableandbackpressure.s165_producerconsumerproblem;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class BackPressureDemo2 {
    public static void main(String[] args) {

        Observable.interval(50, TimeUnit.MILLISECONDS)
                .map(e -> {
                    System.out.println("Producer item is: " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(e -> {
                    sleep(100);
                    System.out.println("Thread is: " + Thread.currentThread().getName());
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
