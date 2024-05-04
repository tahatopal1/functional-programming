package com.project.functional.u24_flowableandbackpressure.s166_flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FlowableDemo {
    public static void main(String[] args) throws InterruptedException {

        // Flowable automatically stops producing at certain point
        // In this example it produce 128 at max at a time, then starts consuming it
        // By doing that, sets a balance without any manual intervention

        Flowable.range(1, 1000000)
                .map(e -> {
                    System.out.println("Produced item: " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .observeOn(Schedulers.io())
                .subscribe(integer -> {
                    Thread.sleep(100);
                    System.out.println("Consumed item: " + integer + " : " + Thread.currentThread().getName());
                });

        Thread.sleep(100000000);
    }

}
