package com.project.functional.u24_flowableandbackpressure.s167_flowablecreation;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CreationDemo_Drop {

    // LATEST: Keeps only the latest emitted item and drops older items when the
    // ... downstream subscriber can't keep up, preventing buffer overflow but
    // ... potentially leading to data loss.

    // So it has a buffer by default by once buffer reaches its limit,
    // ... it misses the rest of the emitted data.

    public static void main(String[] args) throws InterruptedException {
        Flowable.create(emitter -> {
                    for (int i = 0; i < 999999999; i++) {
                        if (emitter.isCancelled()) {
                            return;
                        }
                        System.out.println("Sending  " + i);
                        emitter.onNext(i);
                    }
                    emitter.onComplete();
                }, BackpressureStrategy.DROP)
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    Thread.sleep(200);
                    System.out.println("Received " + i);
                });

        Thread.sleep(60000);
    }
}
