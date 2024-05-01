package com.project.functional.u23_bufferingthrottlingswitching.s161_throttle;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ThrottleLastDemo {
    public static void main(String[] args) {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("A");

            Thread.sleep(200);
            emitter.onNext("B");

            Thread.sleep(100);
            emitter.onNext("C");

            Thread.sleep(400);
            emitter.onNext("D");

            Thread.sleep(300);
            emitter.onNext("E");

            Thread.sleep(800);
            emitter.onNext("F");

            Thread.sleep(900);
            emitter.onNext("X");

            Thread.sleep(600);
            emitter.onNext("Y");

            Thread.sleep(1000);
            emitter.onNext("Z");

            emitter.onComplete();
        });


        // Gets the last emission of 1000 ms duration
        source
                .throttleLast(1000, TimeUnit.MILLISECONDS) // D - F - X - Z
                .subscribe(
                        item -> System.out.println("onNext: " + item),
                        Throwable::printStackTrace,
                        () -> System.out.println("onComplete")
                );
    }

}
