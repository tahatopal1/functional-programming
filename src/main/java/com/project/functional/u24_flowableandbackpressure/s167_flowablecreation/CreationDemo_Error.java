package com.project.functional.u24_flowableandbackpressure.s167_flowablecreation;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CreationDemo_Error {

    // This strategy throws a "MissingBackpressureException" if the downstream
    // ... can't keep up with the rate of emissions. This is useful for debugging
    // and ensuring that the system doesn't proceed with potentially lost data.

    public static void main(String[] args) throws InterruptedException {
        Flowable.create(emitter -> {
                    try {
                        for (int i = 0; i < 99999999; i++) {
                            if (emitter.isCancelled()) {
                                return;
                            }
                            System.out.println("Sending  " + i);
                            emitter.onNext(i);
                        }
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                    emitter.onComplete();
                }, BackpressureStrategy.ERROR)
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    Thread.sleep(200);
                    System.out.println("Received " + i);
                }, throwable -> {
                    System.out.println("Error " + throwable.getMessage());
                });

        Thread.sleep(60000);
    }

}
