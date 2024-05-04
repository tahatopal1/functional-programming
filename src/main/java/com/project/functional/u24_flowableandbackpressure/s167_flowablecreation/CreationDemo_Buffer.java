package com.project.functional.u24_flowableandbackpressure.s167_flowablecreation;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CreationDemo_Buffer {

    // BUFFER: It buffers the emitted items indefinitely until the downstream subscriber can process them,
    // ... potentially leading to increased memory usage if the buffer grows too large.

    public static void main(String[] args) throws InterruptedException {
        Flowable.create(emitter -> {
            for (int i = 0; i < 500; i++) {
                if (emitter.isCancelled()) {
                    return;
                }
                System.out.println("Sending  " + i);
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    Thread.sleep(200);
                    System.out.println("Received " + i);
                });

        Thread.sleep(60000);
    }
}
