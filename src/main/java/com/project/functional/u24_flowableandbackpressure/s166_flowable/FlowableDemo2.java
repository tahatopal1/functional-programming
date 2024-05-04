package com.project.functional.u24_flowableandbackpressure.s166_flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.atomic.AtomicInteger;

public class FlowableDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Flowable.range(1, 1000000)
                .observeOn(Schedulers.io())
                .map(e -> {
                    System.out.println("Produced item: " + e + " : " + Thread.currentThread().getName());
                    return e;
                })
                .subscribe(new Subscriber<Integer>() {
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
                    public void onNext(Integer integer) {

                        if (count.incrementAndGet() % BATCH_SIZE == 0) {
                            System.out.println("Requesting next 20 items");
                            subscription.request(BATCH_SIZE);
                        }

                        System.out.println("The subscriber consumed: " + integer);

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

        Thread.sleep(100000000);
    }}
