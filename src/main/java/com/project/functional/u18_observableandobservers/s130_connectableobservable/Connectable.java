package com.project.functional.u18_observableandobservers.s130_connectableobservable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class Connectable {

    // Connectable observables are the observables that converts
    // ... cold observable into hot observable

    // You can think of hot observables like radio channels.
    // Listeners cannot reply the emission and miss the previous songs.

    public static void main(String[] args) throws InterruptedException {
        ConnectableObservable<Long> source = Observable.interval(1, TimeUnit.SECONDS).publish();
        source.connect();

        source.subscribe(System.out::println);
        Thread.sleep(5000);

        source.subscribe(System.out::println);
        Thread.sleep(5000);

    }
}
