package com.project.functional.u24_flowableandbackpressure.s167_flowablecreation;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;


public class CreationDemo_Missing {

    // MISSING: Doesn't handle backpressure at all, leaving it up tho the subscriber
    // to manage the rate of emissions. (In example, we have limited emissions from subscriber side)

    // In this example, it involuntarily terminates. However, if user implements
    // ... some solutions, it can work seamlessly.

    public static void main(String[] args) throws InterruptedException {

        Flowable.create(emitter -> {
                    try {
                        for (int i = 0; i < 1000; i++) {
                            if (emitter.isCancelled()) {
                                return;
                            }
                            System.out.println("Sending  " + i);
                            emitter.onNext(i);
                            if (emitter.requested() == 0) {
                                System.out.println("No demand, pausing emission");
                                while (emitter.requested() == 0) {
                                    Thread.sleep(100); // Wait until there is demand
                                }
                                System.out.println("Resuming emission");
                            }
                        }
                        //emitter.onComplete();
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                }, BackpressureStrategy.MISSING)
                .observeOn(Schedulers.io())
                .subscribe(new Subscriber<>() {
                    private Subscription subscription;
                    private static final int BATCH_SIZE = 20;
                    private final AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Subscribed");
                        this.subscription = subscription;
                        System.out.println("Requesting 20 items");
                        subscription.request(BATCH_SIZE);
                    }

                    @Override
                    public void onNext(Object o) {
                        if (count.incrementAndGet() % BATCH_SIZE == 0) {
                            System.out.println("Requesting next 20 items");
                            subscription.request(BATCH_SIZE);
                        }

                        System.out.println("The subscriber consumed: " + o);

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }


                    @Override
                    public void onError(Throwable throwable) {
                        throwable.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });


        Thread.sleep(60000);
    }
}
