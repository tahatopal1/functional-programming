package com.project.functional.u18_observableandobservers.s127_observable;

import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        Observable<Object> source = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(11);
                    e.onNext(12);
                    e.onComplete();
                }
        );

        source.subscribe(System.out::println);

        // just()
        System.out.println("----- Just -----");
        Observable<Integer> just = Observable.just(1, 2, 3);
        just.subscribe(System.out::println);

        // fromIterable()
        System.out.println("----- From Iterable -----");
        List<String> list = Arrays.asList("John", "Tom", "Jack");
        Observable<String> fromIterable = Observable.fromIterable(list);
        fromIterable.subscribe(System.out::println);

        // range()
        System.out.println("----- Range -----");
        Observable.range(3, 10)
                .subscribe(s -> System.out.println("Received: " + s));

        // interval()
        System.out.println("----- Interval -----");
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println("Second: " + s));
        Thread.sleep(10000);

    }
}
