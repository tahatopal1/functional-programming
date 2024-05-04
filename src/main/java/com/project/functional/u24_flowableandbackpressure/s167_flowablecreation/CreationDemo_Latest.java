package com.project.functional.u24_flowableandbackpressure.s167_flowablecreation;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CreationDemo_Latest {

    // LATEST: This strategy keeps only the latest item emitted by the upstream
    // ... when the downstream can't keep up. It drops the older items.

    public static void main(String[] args) throws InterruptedException {
        Flowable.create(emitter -> {
                    for (int i = 0; i < 9999999; i++) {
                        if (emitter.isCancelled()) {
                            return;
                        }
                        System.out.println("Sending  " + i);
                        emitter.onNext(i);
                    }
                    emitter.onComplete();
                }, BackpressureStrategy.LATEST)
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    Thread.sleep(100);
                    System.out.println("Received " + i);
                });

        Thread.sleep(60000);
    }

}
