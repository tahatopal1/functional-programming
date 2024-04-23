package com.project.functional.u17_hellorxjava;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class HelloRxJavaAsync {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(
                e -> {
                    e.onNext("Hello");
                    e.onNext("RxJava");
                    e.onComplete(); // Signal completion of the event stream.
                }
        );

        // Subscribe on the IO scheduler for asynchronous behavior.
        Observable<String> stringObservable = source.subscribeOn(Schedulers.io());

        stringObservable.subscribe(e -> System.out.println("Observer 1: " + e));
        stringObservable.subscribe(e -> System.out.println("Observer 2: " + e));

        try {
            Thread.sleep(1000); // Wait for a bit to ensure the asynchronous operations complete.
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
